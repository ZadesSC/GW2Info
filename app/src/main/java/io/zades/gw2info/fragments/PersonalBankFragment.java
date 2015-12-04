package io.zades.gw2info.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;
import io.zades.gw2info.R;
import io.zades.gw2info.adapters.BankAdapter;
import io.zades.gw2info.data.ItemTable;
import io.zades.gw2info.data.pojo.AccountBankDatum;
import io.zades.gw2info.data.pojo.ItemDatum;
import io.zades.gw2info.net.Gw2Api;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalBankFragment extends Fragment implements RecyclerViewExpandableItemManager.OnGroupCollapseListener, RecyclerViewExpandableItemManager.OnGroupExpandListener, SwipeRefreshLayout.OnRefreshListener
{
	private final static String TAG = "PersonalBankFragment";
	private final Gw2Api sApi = Gw2Api.getInstance();
	private final ItemTable sItemTable = ItemTable.getInstance();

	private Toolbar mToolbar;
	private RecyclerView mRecyclerView;
	private RecyclerView.Adapter mAdapter;
	private RecyclerView.LayoutManager mLayoutManager;
	private ActionBarDrawerToggle mDrawerToggle;
	private SwipeRefreshLayout mSwipeRefreshLayout;

	public PersonalBankFragment()
	{
		super();
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_personal_bank, container, false);
		return view;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState)
	{
		super.onViewCreated(view, savedInstanceState);

		mToolbar = (Toolbar) getActivity().findViewById(R.id.app_bar);
		mRecyclerView = (RecyclerView) getView().findViewById(R.id.recycle_view_personal_bank);
		mSwipeRefreshLayout = (SwipeRefreshLayout) getView().findViewById(R.id.refresh_personal_bank);
		mLayoutManager = new LinearLayoutManager(getContext());

		mAdapter = new BankAdapter(getContext());

		mRecyclerView.setAdapter(mAdapter);
		//mRecyclerView.setItemAnimator(animator);
		mRecyclerView.setLayoutManager(mLayoutManager);
		mSwipeRefreshLayout.setOnRefreshListener(this);

		onRefresh(); //load data lazy way
	}

	@Override
	public void onGroupCollapse(int i, boolean b)
	{

	}

	@Override
	public void onGroupExpand(int i, boolean b)
	{

	}

	@Override
	public void onRefresh()
	{
		((BankAdapter)mAdapter).resetData();
		mSwipeRefreshLayout.setRefreshing(true);
		getBankData();
	}

	public void getBankData()
	{
		Call<List<AccountBankDatum>> call = sApi.getAccountBank();
		call.enqueue(new Callback<List<AccountBankDatum>>()
		{
			@Override
			public void onResponse(Response<List<AccountBankDatum>> response, Retrofit retrofit)
			{
				//send to adapter
				Log.d(TAG, response.code() + "");

				((BankAdapter)mAdapter).loadItemNumbers(response.body());
				mSwipeRefreshLayout.setRefreshing(false);

				//grab le ids
				int[] ids = new int[response.body().size()];
				for(int x = 0; x< response.body().size(); x++)
				{
					if(response.body().get(x) == null)
					{
						//Log.d(TAG, "null");
						ids[x] = -1;
					}
					else
					{
						//Log.d(TAG, response.body().get(x).getId() + "");
						ids[x] = response.body().get(x).getId();
					}
				}

				for(int x = 0; x < Math.ceil(ids.length/200.0); x++)
				{
					int[] temp = new int[200];
					if((x + 1) * 200 <= ids.length)
					{
						System.arraycopy(ids, x * 200, temp, 0, 200);
					}
					else
					{
						System.arraycopy(ids, x * 200, temp, 0, ids.length - x*200);
					}

					Log.d(TAG, "Size of sent data: " + temp.length);
					//get item data
					Call<List<ItemDatum>> itemCall = sApi.getItems(temp);
					itemCall.enqueue(new Callback<List<ItemDatum>>()
					{
						@Override
						public void onResponse(Response<List<ItemDatum>> response, Retrofit retrofit)
						{
							Log.d(TAG, response.code() + "");

							//((BankAdapter)mAdapter).loadBankData(response.body());
							sItemTable.storeItems(response.body());
							mAdapter.notifyDataSetChanged();
							mSwipeRefreshLayout.setRefreshing(false);
						}

						@Override
						public void onFailure(Throwable t)
						{
							mSwipeRefreshLayout.setRefreshing(false);

							Toast toast = Toast.makeText(getContext(), "Error while loading", Toast.LENGTH_SHORT);
							toast.show();
						}
					});
				}
			}

			@Override
			public void onFailure(Throwable t)
			{
				mSwipeRefreshLayout.setRefreshing(false);

				Toast toast = Toast.makeText(getContext(), "Error while loading", Toast.LENGTH_SHORT);
				toast.show();
			}
		});
	}
}
