package io.zades.gw2info.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import io.zades.gw2info.R;

/**
 * Created by zades on 11/15/2015.
 */
public class ChildNavigationViewHolder extends ChildViewHolder implements View.OnClickListener
{
	public int holderId;

	public TextView textView;
	public ImageView imageView;
	public TextView name;
	public TextView email;
	public ImageView profile;

	private Context mContext;

	public ChildNavigationViewHolder(View itemView, Context context)
	{
		super(itemView);
		mContext = context;

		itemView.setClickable(true);
		itemView.setOnClickListener(this);

		textView = (TextView) itemView.findViewById(R.id.text_child_nav_row);
		imageView = (ImageView) itemView.findViewById(R.id.image_child_nav_row);
		holderId = 1;
	}

	@Override
	public void onClick(View v)
	{
		Toast.makeText(mContext, "The Item Clicked is: " + getLayoutPosition(), Toast.LENGTH_SHORT).show();
	}
}
