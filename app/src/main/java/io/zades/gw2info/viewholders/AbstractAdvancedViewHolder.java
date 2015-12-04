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

	public AbstractAdvancedViewHolder(View itemView)
	{
		super(itemView);

		itemView.setClickable(true);
		itemView.setOnClickListener(this);
	}

	@Override
	public void onClick(View v)
	{
		switch (getItemViewType())
		{
			case AbstractAdvancedRecyclerViewAdapter.TYPE_PARENT:
				//send event bus over
				mEventBus.post(new AdvancedRecyclerViewClickedEvent(getPosition()));
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
}
