package io.zades.gw2info.events;

/**
 * Created by zades on 11/16/2015.
 */
public class NavigationItemClickedEvent
{
	private int mChildPosition;
	private String mChildTitle;

	public NavigationItemClickedEvent(int position, String title)
	{
		mChildPosition = position;
		mChildTitle = title;
	}

	public int getChildPosition()
	{
		return mChildPosition;
	}
	public String getChildTitle()
	{
		return mChildTitle;
	}
}
