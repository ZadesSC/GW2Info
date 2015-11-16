package io.zades.gw2info.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import io.zades.gw2info.R;

/**
 * Created by zades on 11/15/2015.
 */
public class ChildNavigationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
	public TextView textView;
	public ImageView imageView;

	private Context mContext;

	public ChildNavigationViewHolder(View itemView, Context context)
	{
		super(itemView);
		mContext = context;

		itemView.setClickable(true);
		itemView.setOnClickListener(this);

		textView = (TextView) itemView.findViewById(R.id.text_child_nav_row);
		imageView = (ImageView) itemView.findViewById(R.id.image_child_nav_row);
	}

	@Override
	public void onClick(View v)
	{

	}
}
