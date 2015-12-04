package io.zades.gw2info.models;

/**
 * Created by zades on 12/4/2015.
 */
public class AdvancedRecyclerViewChildDataModel<ChildData>
{
	private int mType;
	protected ChildData mChildData;

	public AdvancedRecyclerViewChildDataModel(ChildData data, int viewType)
	{
		setType(viewType);
		mChildData = data;
	}

	public ChildData getChildData()
	{
		return mChildData;
	}

	public void setChildData(ChildData data)
	{
		mChildData = data;
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
