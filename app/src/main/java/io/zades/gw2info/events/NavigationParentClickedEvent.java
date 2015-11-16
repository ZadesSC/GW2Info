package io.zades.gw2info.events;

/**
 * Created by zades on 11/16/2015.
 */
public class NavigationParentClickedEvent
{
	private int mParentPosition;

	public NavigationParentClickedEvent(int position)
	{
		mParentPosition = position;
	}

	public int getParentPosition()
	{
		return mParentPosition;
	}
}
