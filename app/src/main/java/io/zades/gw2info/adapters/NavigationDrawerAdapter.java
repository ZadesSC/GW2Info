package io.zades.gw2info.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import de.greenrobot.event.EventBus;
import io.zades.gw2info.R;
import io.zades.gw2info.events.NavigationParentClickedEvent;
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
	private static final String TAG = "NavigationDrawerAdapter";

	public static final int TYPE_HEADER = 0;
	public static final int TYPE_PARENT = 1;
	public static final int TYPE_CHILD = 2;

	private static final int NAV_DRAWER_TITLE_ARRAY = R.array.nav_drawer_items;
	private static final int NAV_DRAWER_PERSONAL_ARRAY = R.array.nav_drawer_personal_items;

	//TODO: remove hardcode
	private static final String NAV_HEADER_EMAIL = "test@test.com";
	private static final String NAV_HEADER_NAME = "Test Name";
	private static final int NAV_HEADER_PROFILE = R.drawable.ic_default_profile;

	private EventBus eventBus = EventBus.getDefault();
	private Context mContext;
	private LayoutInflater mInflater;

	private List<ParentNavigationModel> mNavItems;
	private List<BasicNavigationModel> mCurrentViewableList;

	public NavigationDrawerAdapter(Context context)
	{
		eventBus.register(this);
		mContext = context;
		mInflater = LayoutInflater.from(mContext);
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
				v = mInflater.inflate(R.layout.header_navigation, viewGroup, false);
				viewHolderItem = new ParentNavigationViewHolder(v, viewType, mContext);
				return  viewHolderItem;
			case TYPE_PARENT:
				v = mInflater.inflate(R.layout.item_parent_navigation_row, viewGroup, false);
				viewHolderItem = new ParentNavigationViewHolder(v, viewType, mContext);
				return  viewHolderItem;
			case TYPE_CHILD:
				v = mInflater.inflate(R.layout.item_child_navigation_row, viewGroup, false);
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

	public void onEvent(NavigationParentClickedEvent event)
	{
		Toast.makeText(mContext, "The Item Clicked is: " + event.getParentPosition(), Toast.LENGTH_SHORT).show();

		ParentNavigationModel parent = (ParentNavigationModel) mCurrentViewableList.get(event.getParentPosition());

		if(parent.getChildNodes() == null)
		{
			return;
		}

		if(parent.getIsExpanded())
		{
			collapseParent(event.getParentPosition());
		}
		else
		{
			expandParent(event.getParentPosition());
		}
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
				case "Personal":
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

	private void expandParent(int parentPosition)
	{
		if(mCurrentViewableList.get(parentPosition).getViewType() != TYPE_PARENT)
		{
			Log.e(TAG, "Method expandParent evoked but is not a parent at position " + parentPosition);
			return;
		}

		ParentNavigationModel parent = (ParentNavigationModel) mCurrentViewableList.get(parentPosition);

		if(parent.getIsExpanded())
		{
			Log.e(TAG, "Method expandParent evoked but parent already expanded");
			return;
		}

		mCurrentViewableList.addAll(parentPosition + 1, parent.getChildNodes());
		parent.setIsExpanded(true);
		notifyItemRangeInserted(parentPosition + 1, parent.getChildNodes().size());
	}

	private void collapseParent(int parentPosition)
	{
		if(mCurrentViewableList.get(parentPosition).getViewType() != TYPE_PARENT)
		{
			Log.e(TAG, "Method collapseParent evoked but is not a parent at position " + parentPosition);
			return;
		}

		ParentNavigationModel parent = (ParentNavigationModel) mCurrentViewableList.get(parentPosition);

		if(!parent.getIsExpanded())
		{
			Log.e(TAG, "Method collapseParent evoked but parent already collapsed");
			return;
		}

		mCurrentViewableList.removeAll(parent.getChildNodes());
		parent.setIsExpanded(false);
		notifyItemRangeRemoved(parentPosition + 1, parent.getChildNodes().size());
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
