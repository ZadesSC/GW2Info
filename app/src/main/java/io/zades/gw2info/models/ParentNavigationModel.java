package io.zades.gw2info.models;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.List;

/**
 * Created by zades on 11/15/2015.
 */
public class ParentNavigationModel implements ParentListItem
{
	private List<ChildNavigationModel> mCildItemList;
	@Override
	public List<?> getChildItemList()
	{
		return null;
	}

	@Override
	public boolean isInitiallyExpanded()
	{
		return false;
	}
}
