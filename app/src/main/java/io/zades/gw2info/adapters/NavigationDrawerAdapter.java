package io.zades.gw2info.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import de.greenrobot.event.EventBus;
import io.zades.gw2info.R;
import io.zades.gw2info.models.BasicNavigationModel;
import io.zades.gw2info.viewholders.NavigationItemViewHolder;
import io.zades.gw2info.viewholders.NavigationHeaderViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zades on 11/11/2015.
 */
public class NavigationDrawerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
	private static final String TAG = "NavigationDrawerAdapter";

	public static final int TYPE_HEADER = 0;
	public static final int TYPE_ITEM = 2;

	private static final int NAV_DRAWER_TITLE_ARRAY = R.array.nav_drawer_top_items;
	private static final int NAV_DRAWER_PERSONAL_ARRAY = R.array.nav_drawer_personal_items;
	private static final int NAV_DRAWER_TIMER_ARRAY = R.array.nav_drawer_timer_items;

	//TODO: remove hardcode
	private static final String NAV_HEADER_EMAIL = "News and Timers";
	private static final String NAV_HEADER_NAME = "Guild Wars 2 Info";
	private static final int NAV_HEADER_PROFILE = R.drawable.ic_default_profile;

	private Context mContext;
	private LayoutInflater mInflater;

	private List<BasicNavigationModel> mItemList;

	public NavigationDrawerAdapter(Context context)
	{
		mContext = context;
		mInflater = LayoutInflater.from(mContext);
		mItemList = new ArrayList<>();
		createData();
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
	{
		View v;
		RecyclerView.ViewHolder viewHolderItem;
		switch (viewType)
		{
			case TYPE_HEADER:
				v = mInflater.inflate(R.layout.header_navigation, viewGroup, false);
				viewHolderItem = new NavigationHeaderViewHolder(v, viewType, mContext);
				return  viewHolderItem;
			case TYPE_ITEM:
				v = mInflater.inflate(R.layout.item_navigation_row, viewGroup, false);
				viewHolderItem = new NavigationItemViewHolder(v, mContext);
				return  viewHolderItem;
		}

		return null;
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position)
	{
		switch (mItemList.get(position).getViewType())
		{
			case TYPE_HEADER:
				NavigationHeaderViewHolder castedHeader = (NavigationHeaderViewHolder) viewHolder;
				//castedHeader.profile.setImageResource(NAV_HEADER_PROFILE);
				castedHeader.name.setText(NAV_HEADER_NAME);
				castedHeader.email.setText(NAV_HEADER_EMAIL);
				break;
			case TYPE_ITEM:
				NavigationItemViewHolder castedChild = (NavigationItemViewHolder) viewHolder;
				castedChild.textView.setText(mItemList.get(position).getText());
				break;
		}
	}

	@Override
	public int getItemCount()
	{
		return mItemList.size();
	}

	@Override
	public int getItemViewType(int position)
	{
		return mItemList.get(position).getViewType();
	}

	private void createData()
	{
		String[] topTitles = mContext.getResources().getStringArray(NAV_DRAWER_TITLE_ARRAY);
		//String[] personalTitles = mContext.getResources().getStringArray(NAV_DRAWER_PERSONAL_ARRAY);
		String[] timerTitles = mContext.getResources().getStringArray(NAV_DRAWER_TIMER_ARRAY);

		mItemList.add(new BasicNavigationModel("", -1, TYPE_HEADER));

		for(String title: topTitles)
		{
			mItemList.add(new BasicNavigationModel(title, -1, TYPE_ITEM));
		}

//		for(String title: personalTitles)
//		{
//			mItemList.add(new BasicNavigationModel(title, -1, TYPE_ITEM));
//		}

		for(String title: timerTitles)
		{
			mItemList.add(new BasicNavigationModel(title, -1, TYPE_ITEM));
		}

		mItemList.add(new BasicNavigationModel(mContext.getResources().getString(R.string.nav_drawer_info), -1, TYPE_ITEM));
		//TODO: FINISH
	}



//	public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
//	{
//		public int holderId;
//
//		public TextView textView;
//		public ImageView imageView;
//		public TextView name;
//		public TextView email;
//		public ImageView profile;
//
//		private Context mContext;
//
//		public ViewHolder(View itemView, int viewType, Context context)
//		{
//			super(itemView);
//			mContext = context;
//
//			if (viewType == TYPE_ITEM)
//			{
//				itemView.setClickable(true);
//				itemView.setOnClickListener(this);
//
//				textView = (TextView) itemView.findViewById(R.id.text_nav_row);
//				imageView = (ImageView) itemView.findViewById(R.id.image_nav_row);
//				holderId = TYPE_ITEM;
//			}
//			else
//			{
//				name = (TextView) itemView.findViewById(R.id.text_nav_header_name);
//				email = (TextView) itemView.findViewById(R.id.text_nav_header_email);
//				profile = (ImageView) itemView.findViewById(R.id.image_circle_nav_header);
//				holderId = TYPE_HEADER;
//			}
//		}
//
//		@Override
//		public void onClick(View v)
//		{
//			Toast.makeText(mContext, "The Item Clicked is: " + getPosition(), Toast.LENGTH_SHORT).show();
//
//		}
//	}
}
