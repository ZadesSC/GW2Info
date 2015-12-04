package io.zades.gw2info.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zades on 12/4/2015.
 */
public class AdvancedRecyclerViewParentDataModel<ParentData, ChildData>
{
	protected int mType;
	protected List<AdvancedRecyclerViewChildDataModel<ChildData>> mChildList;
	protected ParentData mParentData;
	private boolean mIsCollapsed;

	public AdvancedRecyclerViewParentDataModel(ParentData data, int viewType)
	{
		mType = viewType;
		mParentData = data;
		setIsCollapsed(false);
		mChildList = new ArrayList<>();
	}

	public void add(AdvancedRecyclerViewChildDataModel<ChildData> data)
	{
		mChildList.add(data);
	}

	public int getChildCount()
	{
		return mChildList.size();
	}

	public AdvancedRecyclerViewChildDataModel get(int childPosition)
	{
		return mChildList.get(childPosition);
	}

	public ParentData getParentData()
	{
		return mParentData;
	}

	public void setParentData(ParentData data)
	{
		mParentData = data;
	}

	public boolean isCollapsed()
	{
		return mIsCollapsed;
	}

	public void setIsCollapsed(boolean isCollapsed)
	{
		mIsCollapsed = isCollapsed;
	}

	public int getType()
	{
		return mType;
	}

	public void setType(int mType)
	{
		this.mType = mType;
	}
}
