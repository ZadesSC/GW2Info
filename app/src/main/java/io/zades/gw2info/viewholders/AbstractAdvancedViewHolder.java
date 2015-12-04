package io.zades.gw2info.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import de.greenrobot.event.EventBus;
import io.zades.gw2info.adapters.AbstractAdvancedRecyclerViewAdapter;
import io.zades.gw2info.events.AdvancedRecyclerViewClickedEvent;

/**
 * Created by zades on 12/4/2015.
 */
public abstract class AbstractAdvancedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
	private EventBus mEventBus = EventBus.getDefault();
	private int mParentPosition;
	private int mChildPosition;

	public AbstractAdvancedViewHolder(View itemView, int parentPosition, int childPosition)
	{
		super(itemView);
		getEventBus().register(this);
		this.mParentPosition = parentPosition;
		this.mChildPosition = childPosition;
	}

	@Override
	public void onClick(View v)
	{
		switch (getItemViewType())
		{
			case AbstractAdvancedRecyclerViewAdapter.TYPE_PARENT:
				//send event bus over
				mEventBus.post(new AdvancedRecyclerViewClickedEvent(getParentPosition(), getChildPosition()));
				break;
			default:
				onClickPostAdvancedProcessing(v);
				break;
		}
	}

	public abstract void onClickPostAdvancedProcessing(View v);

	protected EventBus getEventBus()
	{
		return mEventBus;
	}

	protected void setEventBus(EventBus eventBus)
	{
		mEventBus = eventBus;
	}

	public int getParentPosition()
	{
		return mParentPosition;
	}

	public void setParentPosition(int mParentPosition)
	{
		this.mParentPosition = mParentPosition;
	}

	public int getChildPosition()
	{
		return mChildPosition;
	}

	public void setChildPosition(int mChildPosition)
	{
		this.mChildPosition = mChildPosition;
	}
}
