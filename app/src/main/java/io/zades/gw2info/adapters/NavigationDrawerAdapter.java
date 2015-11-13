package io.zades.gw2info.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import io.zades.gw2info.R;

/**
 * Created by zades on 11/11/2015.
 */
public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.ViewHolder>
{

	private static final int TYPE_HEADER = 0;    // Declaring Variable to Understand which View is being worked on
	// IF the view under inflation and population is header or Item
	private static final int TYPE_ITEM = 1;

	private Context mContext;

	private String mNavTitles[]; // Stores titles
	private int mIcons[];       // Stores icons

	private String name;        //String Resource for header View Name
	private int profile;        //int Resource for header view profile picture
	private String email;       //String Resource for header view email

	public NavigationDrawerAdapter(Context context)
	{
		mContext = context;
		mNavTitles = mContext.getResources().getStringArray(R.array.nav_drawer_items);
		//icons
		//TODO: remove hardcode
		name = "TestName";
		email = "test@email.com";
		profile = R.drawable.ic_default_profile;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
	{
		if(viewType == TYPE_ITEM)
		{
			View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_navigation, viewGroup, false);
			ViewHolder viewHolderItem = new ViewHolder(v, viewType, mContext);
			return  viewHolderItem;

		}
		else if(viewType == TYPE_HEADER)
		{
			View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.header_navigation, viewGroup, false);
			ViewHolder viewHolderItem = new ViewHolder(v, viewType, mContext);
			return  viewHolderItem;
		}
		return null;
	}

	@Override
	public void onBindViewHolder(ViewHolder viewHolder, int position)
	{
		if(viewHolder.holderId == TYPE_ITEM)
		{
			viewHolder.textView.setText(mNavTitles[position-1]);
			//do image
		}
		else
		{
			viewHolder.profile.setImageResource(profile);
			viewHolder.name.setText(name);
			viewHolder.email.setText(email);
		}
	}

	@Override
	public int getItemCount()
	{
		return mNavTitles.length + 1;
	}

	@Override
	public int getItemViewType(int position)
	{
		if(position == TYPE_HEADER) //maybe change for saftety?  0th position is header
		{
			return TYPE_HEADER;
		}
		return TYPE_ITEM;
	}


	public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
	{
		public int holderId;

		public TextView textView;
		public ImageView imageView;
		public TextView name;
		public TextView email;
		public ImageView profile;

		private Context mContext;

		public ViewHolder(View itemView, int viewType, Context context)
		{
			super(itemView);
			mContext = context;

			if (viewType == TYPE_ITEM)
			{
				itemView.setClickable(true);
				itemView.setOnClickListener(this);

				textView = (TextView) itemView.findViewById(R.id.text_nav_row);
				imageView = (ImageView) itemView.findViewById(R.id.image_nav_row);
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

		@Override
		public void onClick(View v)
		{
			Toast.makeText(mContext, "The Item Clicked is: " + getPosition(), Toast.LENGTH_SHORT).show();

		}
	}
}
