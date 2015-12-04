package io.zades.gw2info.models;

import android.support.annotation.Nullable;
import android.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by zades on 12/4/2015.
 */
public class AdvancedRecyclerViewDataModel<ParentData, ChildData>
{
	protected List<AdvancedRecyclerViewParentDataModel<ParentData, ChildData>> mParentList;

	public AdvancedRecyclerViewDataModel()
	{
		//something does in here...maybe
		mParentList = new ArrayList<>();
	}

	public void addParent(ParentData data, int viewType)
	{
		AdvancedRecyclerViewParentDataModel<ParentData, ChildData> newParentItem= new AdvancedRecyclerViewParentDataModel<>(data, viewType);
		mParentList.add(newParentItem);
	}

	public void addChild(ChildData data, int viewType)
	{
		if(mParentList.size() == 0)
		{
			return; //TODO: add error
		}

		AdvancedRecyclerViewChildDataModel<ChildData> newChildItem = new AdvancedRecyclerViewChildDataModel<>(data, viewType);
		mParentList.get(mParentList.size()-1).add(newChildItem);
	}

	public void addChild(ChildData data, int viewType, int parentPosition)
	{
		//TODO: maybe check if the parent exits first
		AdvancedRecyclerViewChildDataModel<ChildData> newChildItem = new AdvancedRecyclerViewChildDataModel<>(data, viewType);
		mParentList.get(parentPosition).add(newChildItem);
	}

	public int getParentCount()
	{
		return mParentList.size();
	}
	public int getChildCount(int parentPosition)
	{
		return mParentList.get(parentPosition).getChildCount();
	}

	public AdvancedRecyclerViewParentDataModel getParent(int parentPosition)
	{
		return mParentList.get(parentPosition);
	}

	public ParentData getParentData(int parentPosition)
	{
		return mParentList.get(parentPosition).getParentData();
	}

	public AdvancedRecyclerViewChildDataModel getChild(int parentPosition, int childPosition)
	{
		return mParentList.get(parentPosition).get(childPosition);
	}
	public ChildData getChildData(int parentPosition, int childPosition)
	{
		return (ChildData) mParentList.get(parentPosition).get(childPosition).getChildData();
	}

	public int getTotalItemCount()
	{
		int count = getParentCount();

		for(AdvancedRecyclerViewParentDataModel<ParentData, ChildData> data: mParentList)
		{
			count += data.getChildCount();
		}

		return count;
	}

	public int getVisibleItemCount()
	{
		int count = getParentCount();	//parents are added regardless of collapse

		for(AdvancedRecyclerViewParentDataModel<ParentData, ChildData> data: mParentList)
		{
			if(!data.isCollapsed())
			{
				count += data.getChildCount(); //add size of child
			}
		}

		return count;
	}


	public int translatePosition(int parentPosition, int childPosition)
	{
		int listPosition = 0;

		for(int x = 0; x < parentPosition; x++)
		{
			listPosition ++; //adds 1 for each parent

			if(mParentList.get(x).isCollapsed())
			{
				continue;
			}

			listPosition += mParentList.get(x).getChildCount(); //adds the count for childs
		}

		listPosition++; //add another one for the parent the child is currently one
		listPosition += childPosition + 1; //adds the childs leading up to the childposition

		return listPosition;
	}

	/**
	 * Returns the VISIBLE translated position
	 * @param position
	 * @return
	 */
	public Pair<Integer, Integer> translatePosition(int position)
	{
		int positionCounter = position;

		for(int x  = 0; x < mParentList.size(); x++)
		{
			if(positionCounter == 0)
			{
				return new Pair<>(x, -1);
			}

			positionCounter--;

			if(mParentList.get(x).isCollapsed())
			{
				continue;
			}

			AdvancedRecyclerViewParentDataModel parentData = mParentList.get(x);

			if(positionCounter <= parentData.getChildCount() - 1)
			{
				//<x, positionCounter>
				return new Pair<>(x, positionCounter);
			}

			positionCounter -= parentData.getChildCount();
		}

		return null; //something gone goofed
	}

	/**
	 * Returns the type at a VISIBLE position
	 * @param position
	 * @return
	 */
	public int getType(int position)
	{
		Pair<Integer, Integer> pair = translatePosition(position);

		return getType(pair.first, pair.second);
	}

	public int getType(int parentPosition, int childPosition)
	{
		if(childPosition == -1)
		{
			return mParentList.get(parentPosition).getType();
		}

		return mParentList.get(parentPosition).get(childPosition).getType();
	}
}
