package io.zades.gw2info.models;


import java.util.List;

/**
 * Created by zades on 11/15/2015.
 */
public class ParentNavigationModel extends BasicNavigationModel
{
	private List<ChildNavigationModel> mChildNodes;

	public ParentNavigationModel(String text, int icon, int viewType, List<ChildNavigationModel> childNodes)
	{
		super(text, icon, viewType);
		mChildNodes = childNodes;
	}

	public List<ChildNavigationModel> getChildNodes()
	{
		return mChildNodes;
	}

	public void setmChildNodes(List<ChildNavigationModel> childNodes)
	{
		mChildNodes = childNodes;
	}
}
