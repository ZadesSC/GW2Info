package io.zades.gw2info.models;


import java.util.List;

/**
 * Created by zades on 11/15/2015.
 */
public class ParentNavigationModel extends BasicNavigationModel
{
	private List<ChildNavigationModel> mChildNodes;
	private boolean mIsExpanded;

	public ParentNavigationModel(String text, int icon, int viewType, List<ChildNavigationModel> childNodes)
	{
		super(text, icon, viewType);
		mChildNodes = childNodes;
		mIsExpanded = false;
	}

	public List<ChildNavigationModel> getChildNodes()
	{
		return mChildNodes;
	}

	public void setChildNodes(List<ChildNavigationModel> childNodes)
	{
		mChildNodes = childNodes;
	}

	public boolean getIsExpanded()
	{
		return mIsExpanded;
	}

	public void setIsExpanded(boolean isExpanded)
	{
		mIsExpanded = isExpanded;
	}
}
