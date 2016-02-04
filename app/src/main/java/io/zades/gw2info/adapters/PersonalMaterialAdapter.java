package io.zades.gw2info.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.squareup.picasso.Picasso;
import io.zades.gw2info.R;
import io.zades.gw2info.data.ItemTable;
import io.zades.gw2info.data.pojo.AccountBankDatum;
import io.zades.gw2info.data.pojo.ItemDatum;
import io.zades.gw2info.data.pojo.MaterialDatum;
import io.zades.gw2info.graphics.IconBorderTransformation;
import io.zades.gw2info.models.AdvancedRecyclerViewChildDataModel;
import io.zades.gw2info.models.AdvancedRecyclerViewParentDataModel;
import io.zades.gw2info.models.BankChildModel;
import io.zades.gw2info.models.BankParentModel;
import io.zades.gw2info.net.Gw2Api;
import io.zades.gw2info.viewholders.BankChildViewHolder;
import io.zades.gw2info.viewholders.BankParentViewHolder;

import java.util.List;

/**
 * Created by zades on 12/4/2015.
 */
public class PersonalMaterialAdapter extends AbstractAdvancedRecyclerViewAdapter<BankParentModel, BankChildModel>
{
	private static final String TAG = "PersonalBankAdapter";

	public static final int TYPE_CHILD = 1;

	private final Gw2Api sApi = Gw2Api.getInstance();
	private final ItemTable sItemTable = ItemTable.getInstance();

	private Context mContext;
	private LayoutInflater mInflator;

	private int dataPtr = 0;

	public PersonalMaterialAdapter(Context context)
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
				bindChild(castedChild, pair);
				break;
		}
	}

	public void bindChild(BankChildViewHolder holder, Pair<Integer, Integer> position)
	{
		if(mDataModel.getChildData(position.first, position.second).getItemData() != null)
		{
			Long id = mDataModel.getChildData(position.first, position.second).getItemData().getId();
			holder.setId(id);
			ItemDatum itemData = sItemTable.getItemData(id);
			int itemAmount = mDataModel.getChildData(position.first, position.second).getAmount();

			if(itemData == null)
			{
				holder.textView.setText("Item ID: " + id);
				Picasso.with(mContext).load(R.drawable.icon_placeholder).into(holder.imageView);
			}
			else
			{
				holder.textView.setText(itemAmount + " " + itemData.getName());
				Picasso.with(mContext).load(itemData.getIcon()).placeholder(R.drawable.icon_placeholder).transform(new IconBorderTransformation(itemData.getRarity(), itemAmount, mContext)).into(holder.imageView);
			}
		}
		else
		{
			//holder.textView.setText("null");
			Picasso.with(mContext).load(R.drawable.icon_placeholder).into(holder.imageView);
		}
	}

	public void resetData()
	{
		super.resetData();
		dataPtr = 0;
	}

	//dont need anymore, should never be called
	public synchronized void loadBankData(List<ItemDatum> data)
	{
		//need to find value and dump the data in it so yea

		for(int x = 0; x < mDataModel.getParentCount(); x++)
		{
			AdvancedRecyclerViewParentDataModel<BankParentModel, BankChildModel> parent = mDataModel.getParent(x);
			for(int y = 0; y < parent.getChildCount(); y++)
			{
				AdvancedRecyclerViewChildDataModel<BankChildModel> child = mDataModel.getChild(x, y);
				if(child.getChildData().getItemData() != null)
				{
					if(child.getChildData().getItemData().getId() == data.get(dataPtr).getId())
					{
						child.getChildData().setItemData(data.get(dataPtr));
						dataPtr++;
					}
					else
					{
						Log.e(TAG, "Non Matching Ids in data");
					}
				}
			}
		}

	}

	public synchronized void loadMaterialTabs(List<MaterialDatum> data)
	{

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
				model.setAmount(data.get(x).getCount());

			}
			mDataModel.addChild(model, TYPE_CHILD);
			count ++;
		}

		notifyDataSetChanged();
	}
}
