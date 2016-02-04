package io.zades.gw2info.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import de.greenrobot.event.EventBus;
import io.zades.gw2info.R;
import io.zades.gw2info.adapters.NavigationDrawerAdapter;
import io.zades.gw2info.events.NavigationParentClickedEvent;

/**
 * Created by zades on 11/15/2015.
 */
public class NavigationHeaderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
	public int holderId;

	public TextView textView;
	public ImageView imageView;
	public TextView name;
	public TextView email;
	public ImageView profile;

	private Context mContext;

	public NavigationHeaderViewHolder(View itemView, int viewType, Context context)
	{
		super(itemView);
		mContext = context;
		name = (TextView) itemView.findViewById(R.id.text_nav_header_name);
		email = (TextView) itemView.findViewById(R.id.text_nav_header_email);
		profile = (ImageView) itemView.findViewById(R.id.image_circle_nav_header);
		holderId = 0;

	}

	@Override
	public void onClick(View v)
	{
		switch (getItemViewType())
		{
			case NavigationDrawerAdapter.TYPE_HEADER:
				break;
		}
	}
}
