package io.zades.gw2info.events;

/**
 * Created by zades on 12/4/2015.
 */
public class AdvancedRecyclerViewClickedEvent
{
	private int mParentPosition;
	private int mChildPosition;

	public AdvancedRecyclerViewClickedEvent(int parentPosition, int childPosition)
	{
		this.mParentPosition = parentPosition;
		this.mChildPosition = childPosition;
	}

	public int getParentPosition()
	{
		return mParentPosition;
	}

	public int getChildPosition()
	{
		return mChildPosition;
	}
}
