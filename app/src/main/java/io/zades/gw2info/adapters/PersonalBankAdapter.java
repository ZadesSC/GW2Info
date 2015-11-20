package io.zades.gw2info.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemAdapter;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemViewHolder;
import io.zades.gw2info.data.AccountBankDatum;

import java.util.List;

/**
 * Created by zades on 11/19/2015.
 */
public class PersonalBankAdapter extends AbstractExpandableItemAdapter
{
	private static final int SLOTS_PER_TAB = 30;

	private List<AccountBankDatum> mData;

	public PersonalBankAdapter(Context context)
	{
		mData = null;
	}

	@Override
	public int getGroupCount()
	{
		return 0;
	}

	@Override
	public int getChildCount(int i)
	{
		return 0;
	}

	@Override
	public long getGroupId(int i)
	{
		return 0;
	}

	@Override
	public long getChildId(int i, int i1)
	{
		return 0;
	}

	@Override
	public int getGroupItemViewType(int i)
	{
		return 0;
	}

	@Override
	public int getChildItemViewType(int i, int i1)
	{
		return 0;
	}

	@Override
	public RecyclerView.ViewHolder onCreateGroupViewHolder(ViewGroup viewGroup, int i)
	{
		return null;
	}

	@Override
	public RecyclerView.ViewHolder onCreateChildViewHolder(ViewGroup viewGroup, int i)
	{
		return null;
	}

	@Override
	public void onBindGroupViewHolder(RecyclerView.ViewHolder viewHolder, int i, int i1)
	{

	}

	@Override
	public void onBindChildViewHolder(RecyclerView.ViewHolder viewHolder, int i, int i1, int i2)
	{

	}

	@Override
	public boolean onCheckCanExpandOrCollapseGroup(RecyclerView.ViewHolder viewHolder, int i, int i1, int i2, boolean b)
	{
		return false;
	}

	public void loadData(List<AccountBankDatum> data)
	{
		mData = data;
	}

	public class HeaderViewHolder extends AbstractExpandableItemViewHolder
	{

		public HeaderViewHolder(View itemView)
		{
			super(itemView);
		}
	}

	public class ItemViewHolder extends AbstractExpandableItemViewHolder
	{

		public ItemViewHolder(View itemView)
		{
			super(itemView);
		}
	}
}
