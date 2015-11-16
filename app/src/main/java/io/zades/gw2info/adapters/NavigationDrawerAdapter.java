package io.zades.gw2info.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import io.zades.gw2info.R;
import io.zades.gw2info.models.BasicNavigationModel;
import io.zades.gw2info.models.ChildNavigationModel;
import io.zades.gw2info.models.ParentNavigationModel;
import io.zades.gw2info.viewholders.ChildNavigationViewHolder;
import io.zades.gw2info.viewholders.ParentNavigationViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zades on 11/11/2015.
 */
public class NavigationDrawerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

	public static final int TYPE_HEADER = 0;
	public static final int TYPE_PARENT = 1;
	public static final int TYPE_CHILD = 2;

	private static final int NAV_DRAWER_TITLE_ARRAY = R.array.nav_drawer_items;
	private static final int NAV_DRAWER_PERSONAL_ARRAY = R.array.nav_drawer_personal_items;

	private static final String NAV_HEADER_EMAIL = "test@test.com";
	private static final String NAV_HEADER_NAME = "Test Name";
	private static final int NAV_HEADER_PROFILE = R.drawable.ic_default_profile;

	private Context mContext;

	private List<ParentNavigationModel> mNavItems;
	private List<BasicNavigationModel> mCurrentViewableList;

	public NavigationDrawerAdapter(Context context)
	{
		mContext = context;
		mNavItems = new ArrayList<>();
		mCurrentViewableList = new ArrayList<>();
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
				v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.header_navigation, viewGroup, false);
				viewHolderItem = new ParentNavigationViewHolder(v, viewType, mContext);
				return  viewHolderItem;
			case TYPE_PARENT:
				v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_parent_navigation_row, viewGroup, false);
				viewHolderItem = new ParentNavigationViewHolder(v, viewType, mContext);
				return  viewHolderItem;
			case TYPE_CHILD:
				v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_child_navigation_row, viewGroup, false);
				viewHolderItem = new ChildNavigationViewHolder(v, mContext);
				return  viewHolderItem;
		}

		return null;
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position)
	{
		switch (mCurrentViewableList.get(position).getViewType())
		{
			case TYPE_HEADER:
				ParentNavigationViewHolder castedHeader = (ParentNavigationViewHolder) viewHolder;
				castedHeader.profile.setImageResource(NAV_HEADER_PROFILE);
				castedHeader.name.setText(NAV_HEADER_NAME);
				castedHeader.email.setText(NAV_HEADER_EMAIL);
				break;
			case TYPE_PARENT:
				ParentNavigationViewHolder castedParent = (ParentNavigationViewHolder) viewHolder;
				castedParent.textView.setText(mCurrentViewableList.get(position).getText());
				break;
			case TYPE_CHILD:
				ChildNavigationViewHolder castedChild = (ChildNavigationViewHolder) viewHolder;
				castedChild.textView.setText(mCurrentViewableList.get(position).getText());
				break;
		}
	}

	@Override
	public int getItemCount()
	{
		return mCurrentViewableList.size();
	}

	@Override
	public int getItemViewType(int position)
	{
		return mCurrentViewableList.get(position).getViewType();
	}

	private void createData()
	{
		String[] navTitles = mContext.getResources().getStringArray(NAV_DRAWER_TITLE_ARRAY);
		String[] personalTitles = mContext.getResources().getStringArray(NAV_DRAWER_PERSONAL_ARRAY);

		add(new ParentNavigationModel("", 0, TYPE_HEADER, null));

		for(String title: navTitles)
		{
			ParentNavigationModel parent;
			switch (title)
			{
				case "PERSONAL":
					parent = new ParentNavigationModel(title, 0, TYPE_PARENT, createChildData(personalTitles));
					add(parent);
					break;
				default:
					parent = new ParentNavigationModel(title, 0, TYPE_PARENT, null);
					add(parent);
					break;
			}
		}
	}

	private List<ChildNavigationModel> createChildData(String[] childTitle)
	{
		List<ChildNavigationModel> childList = new ArrayList<>(childTitle.length);
		for(String title: childTitle)
		{
			ChildNavigationModel child = new ChildNavigationModel(title, 0, TYPE_CHILD);
			childList.add(child);
		}
		return childList;
	}

	private void add(ParentNavigationModel parent)
	{
		mNavItems.add(parent);
		mCurrentViewableList.add(parent);
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
