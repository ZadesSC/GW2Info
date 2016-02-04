package io.zades.gw2info.models;

/**
 * Created by zades on 11/15/2015.
 */
public class BasicNavigationModel
{
	protected String mText;
	protected int mIcon;
	protected int mViewType;

	public BasicNavigationModel(String text, int icon, int viewType)
	{
		mText = text;
		mIcon = icon;
		mViewType = viewType;
	}

	public String getText()
	{
		return mText;
	}

	public void setText(String text)
	{
		mText = text;
	}

	public int getIcon()
	{
		return mIcon;
	}

	public void setIcon(int icon)
	{
		mIcon = icon;
	}

	public int getViewType()
	{
		return mViewType;
	}

	public void setViewType(int viewType)
	{
		mViewType = viewType;
	}
}
