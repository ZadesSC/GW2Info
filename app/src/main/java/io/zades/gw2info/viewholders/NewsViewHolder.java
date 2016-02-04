package io.zades.gw2info.viewholders;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import de.greenrobot.event.EventBus;
import io.zades.gw2info.R;
import io.zades.gw2info.events.NewsItemClickedEvent;

/**
 * Created by zades on 1/18/2016.
 */
public class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
	private EventBus mEventBus = EventBus.getDefault();

	public TextView mTextNewsTitle;
	public TextView mTextNewsDetails;
	public ImageView mImageView;
	public Uri mUrl;

	public NewsViewHolder(View itemView)
	{
		super(itemView);
		mTextNewsTitle = (TextView) itemView.findViewById(R.id.text_news_title);
		mImageView = (ImageView) itemView.findViewById(R.id.image_news);
		mUrl = null;
		//mTextNewsDetails = (TextView) itemView.findViewById(R.id.text_news_details);

		itemView.setClickable(true);
		itemView.setOnClickListener(this);
	}

	@Override
	public void onClick(View v)
	{
		if(mUrl != null)
		{
			mEventBus.post(new NewsItemClickedEvent(mUrl));
		}
	}
}
