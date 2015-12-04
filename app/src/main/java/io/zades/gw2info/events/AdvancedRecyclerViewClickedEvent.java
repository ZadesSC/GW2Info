package io.zades.gw2info.events;

/**
 * Created by zades on 12/4/2015.
 */
public class AdvancedRecyclerViewClickedEvent
{
	private int mPosition;

	public AdvancedRecyclerViewClickedEvent(int position)
	{
		setPosition(position);
	}

	public int getPosition()
	{
		return mPosition;
	}

	public void setPosition(int mPosition)
	{
		this.mPosition = mPosition;
	}
}
