package io.zades.gw2info.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import io.zades.gw2info.R;
import io.zades.gw2info.adapters.NavigationDrawerAdapter;

/**
 * Created by zades on 11/15/2015.
 */
public class ParentNavigationViewHolder extends RecyclerView.ViewHolder
{
	public int holderId;

	public TextView textView;
	public ImageView imageView;
	public TextView name;
	public TextView email;
	public ImageView profile;

	private Context mContext;

	public ParentNavigationViewHolder(View itemView, int viewType, Context context)
	{
		super(itemView);
		mContext = context;

		if (viewType == NavigationDrawerAdapter.TYPE_PARENT)
		{
			itemView.setClickable(true);
			//itemView.setOnClickListener(this);

			textView = (TextView) itemView.findViewById(R.id.text_parent_nav_row);
			imageView = (ImageView) itemView.findViewById(R.id.image_parent_nav_row);
			holderId = 1;
		}
		else
		{
			name = (TextView) itemView.findViewById(R.id.text_nav_header_name);
			email = (TextView) itemView.findViewById(R.id.text_nav_header_email);
			profile = (ImageView) itemView.findViewById(R.id.image_circle_nav_header);
			holderId = 0;
		}
	}
}
