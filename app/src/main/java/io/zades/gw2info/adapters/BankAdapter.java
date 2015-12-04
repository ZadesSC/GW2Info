package io.zades.gw2info.adapters;

import android.accounts.Account;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import io.zades.gw2info.R;
import io.zades.gw2info.data.AccountBankDatum;
import io.zades.gw2info.data.ItemDatum;
import io.zades.gw2info.models.BankChildModel;
import io.zades.gw2info.models.BankParentModel;
import io.zades.gw2info.net.Gw2Api;
import io.zades.gw2info.viewholders.BankChildViewHolder;
import io.zades.gw2info.viewholders.BankParentViewHolder;
import io.zades.gw2info.viewholders.ParentNavigationViewHolder;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

import java.util.List;
import java.util.Locale;

/**
 * Created by zades on 12/4/2015.
 */
public class BankAdapter extends AbstractAdvancedRecyclerViewAdapter<BankParentModel, BankChildModel>
{
	private static final String TAG = "BankAdapter";

	public static final int TYPE_CHILD = 1;

	private final Gw2Api sApi = Gw2Api.getInstance();

	private Context mContext;
	private LayoutInflater mInflator;

	public BankAdapter(Context context)
	{
		super();
		mContext = context;
		mInflator = LayoutInflater.from(mContext);
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
	{
		View v;
		RecyclerView.ViewHolder viewHolderItem;
		switch(viewType)
		{
			case AbstractAdvancedRecyclerViewAdapter.TYPE_PARENT:
				v = mInflator.inflate(R.layout.item_bank_parent_row, parent, false);
				viewHolderItem = new BankParentViewHolder(v, mContext);
				return viewHolderItem;
			case TYPE_CHILD:
				v = mInflator.inflate(R.layout.item_bank_child_row, parent, false);
				viewHolderItem = new BankChildViewHolder(v, mContext);
				return viewHolderItem;
		}
		return null;
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
	{
		Pair<Integer, Integer> pair = mDataModel.translatePosition(position);

		switch(mDataModel.getType(position))
		{
			case AbstractAdvancedRecyclerViewAdapter.TYPE_PARENT:
				BankParentViewHolder castedParent = (BankParentViewHolder) holder;
				castedParent.textView.setText(mDataModel.getParentData(pair.first).getBankTabString());
				break;
			case TYPE_CHILD:
				BankChildViewHolder castedChild = (BankChildViewHolder) holder;
				if(mDataModel.getChildData(pair.first, pair.second).getItemData() != null)
				{
					castedChild.textView.setText(mDataModel.getChildData(pair.first, pair.second).getItemData().getId() + "");
				}
				else
				{
					castedChild.textView.setText("null");
				}
				break;
		}
	}

	public synchronized void loadBankData(List<ItemDatum> data)
	{
		//skip for now?
		//need to find value and dump the data in it so yea
	}

	public synchronized void loadItemNumbers(List<AccountBankDatum> data)
	{
		int count = 0;
		int headerTab = 1;

		for(int x = 0; x < data.size(); x++)
		{
			if(count%30 == 0)
			{
				//make a header per 30 items
				mDataModel.addParent(new BankParentModel(headerTab - 1), AbstractAdvancedRecyclerViewAdapter.TYPE_PARENT);
				headerTab++;
			}
			BankChildModel model = new BankChildModel();

			if(data.get(x) == null)
			{
				model.setItemData(null);
			}
			else
			{
				model.setItemData(new ItemDatum());
				model.getItemData().setId(data.get(x).getId().longValue());

			}
			mDataModel.addChild(model, TYPE_CHILD);
			count ++;
		}

		notifyDataSetChanged();
	}
}
