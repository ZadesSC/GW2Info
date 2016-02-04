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
import de.greenrobot.event.EventBus;
import io.zades.gw2info.R;
import io.zades.gw2info.adapters.PersonalBankAdapter;
import io.zades.gw2info.adapters.PersonalMaterialAdapter;
import io.zades.gw2info.data.ItemTable;
import io.zades.gw2info.data.pojo.AccountBankDatum;
import io.zades.gw2info.data.pojo.AccountMaterialDatum;
import io.zades.gw2info.data.pojo.ItemDatum;
import io.zades.gw2info.data.pojo.MaterialDatum;
import io.zades.gw2info.events.PersonalBankItemClickedEvent;
import io.zades.gw2info.net.Gw2Api;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalMaterialFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener
{
	private final static String TAG = "PersonalBankFragment";
	private final Gw2Api sApi = Gw2Api.getInstance();
	private final ItemTable sItemTable = ItemTable.getInstance();
	private final EventBus sEventBus = EventBus.getDefault();

	private Toolbar mToolbar;
	private RecyclerView mRecyclerView;
	private RecyclerView.Adapter mAdapter;
	private RecyclerView.LayoutManager mLayoutManager;
	private ActionBarDrawerToggle mDrawerToggle;
	private SwipeRefreshLayout mSwipeRefreshLayout;

	private ConcurrentHashMap<Long, Long> mMatCountTable = new ConcurrentHashMap<>();

	public PersonalMaterialFragment()
	{
		super();
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_personal_material, container, false);
		return view;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState)
	{
		super.onViewCreated(view, savedInstanceState);

		mToolbar = (Toolbar) getActivity().findViewById(R.id.app_bar);
		mRecyclerView = (RecyclerView) getView().findViewById(R.id.recycle_view_personal_material);
		mSwipeRefreshLayout = (SwipeRefreshLayout) getView().findViewById(R.id.refresh_personal_material);
		mLayoutManager = new LinearLayoutManager(getContext());

		mAdapter = new PersonalMaterialAdapter(getContext());

		mRecyclerView.setAdapter(mAdapter);
		//mRecyclerView.setItemAnimator(animator);
		mRecyclerView.setLayoutManager(mLayoutManager);
		mSwipeRefreshLayout.setOnRefreshListener(this);


		onRefresh(); //load data lazy way
	}

	@Override
	public void onResume()
	{
		super.onResume();
		sEventBus.register(this);
	}

	@Override
	public void onPause()
	{
		super.onPause();
		sEventBus.unregister(this);
	}

	@Override
	public void onRefresh()
	{
		((PersonalBankAdapter)mAdapter).resetData();
		mSwipeRefreshLayout.setRefreshing(true);
		//getBankData();
		getMaterialData();
	}

	public void getMaterialData()
	{
		//first populate material tabs, then pull account data
		//using hardcode for speed
		//might need to change later
		//TODO: maybe change this, would involve another API call tho
		int[] matIds = {5,6,39,30,37,38,46};
		Call<List<MaterialDatum>> call = sApi.getMaterial(matIds);
		call.enqueue(new Callback<List<MaterialDatum>>()
		{
			@Override
			public void onResponse(Response<List<MaterialDatum>> response, Retrofit retrofit)
			{
				//create structural model then populate
				((PersonalMaterialAdapter) mAdapter).loadMaterialTabs(response.body());
				mSwipeRefreshLayout.setRefreshing(false);

				//pull item data
				int numIds = 0;
				for (MaterialDatum datum : response.body())
				{
					numIds += datum.getItems().size();
				}

				//TODO: change ids to long across whole program
				int[] ids = new int[numIds];
				int counter = 0;
				for (MaterialDatum datumL : response.body())
				{
					for (Long id : datumL.getItems())
					{
						ids[counter] = id.intValue();
						counter++;
					}
				}

				//item call after breaking amount into 200s
				for (int x = 0; x < Math.ceil(ids.length / 200.0); x++)
				{
					int[] temp = new int[200];
					if ((x + 1) * 200 <= ids.length)
					{
						System.arraycopy(ids, x * 200, temp, 0, 200);
					}
					else
					{
						System.arraycopy(ids, x * 200, temp, 0, ids.length - x * 200);
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

							//((PersonalBankAdapter)mAdapter).loadBankData(response.body());
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
							Log.e(TAG, t.getMessage() + "");
						}
					});
				}
			}

			@Override
			public void onFailure(Throwable t)
			{
				//getMaterial() failed
				Toast toast = Toast.makeText(getContext(), "Error while loading" , Toast.LENGTH_SHORT);
				toast.show();
				Log.e(TAG, t.getMessage() + "");
			}
		});

		//pull account material data and populate
		Call<List<AccountMaterialDatum>> accountMatCall = sApi.getAccountMaterial();

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

				((PersonalMaterialAdapter)mAdapter).loadItemNumbers(response.body());
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

							//((PersonalBankAdapter)mAdapter).loadBankData(response.body());
							sItemTable.storeItems(response.body());
							mAdapter.notifyDataSetChanged();
							mSwipeRefreshLayout.setRefreshing(false);
						}

						@Override
						public void onFailure(Throwable t)
						{
							mSwipeRefreshLayout.setRefreshing(false);

							Toast toast = Toast.makeText(getContext(), "Error while loading" , Toast.LENGTH_SHORT);
							toast.show();
							Log.e(TAG, t.getMessage() + "");
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

				StringWriter sw = new StringWriter();
				t.printStackTrace(new PrintWriter(sw));
				String exceptionAsString = sw.toString();
				Log.e(TAG, exceptionAsString + "");
			}
		});
	}

	public void onEvent(PersonalBankItemClickedEvent event)
	{
		getActivity().getSupportFragmentManager()
				.beginTransaction()
				.hide(this)
				// .setCustomAnimations(R.anim.abc_slide_in_top, R.anim.abc_slide_out_bottom)	//TODO: fix animation
				.add(R.id.frame_layout_content, ItemInfoFragment.newInstance(event.getItemId()), "item detail")
				.addToBackStack(null)
				.commit();
	}
}
