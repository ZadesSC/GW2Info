package io.zades.gw2info.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;
import de.greenrobot.event.EventBus;
import io.zades.gw2info.events.AdvancedRecyclerViewClickedEvent;
import io.zades.gw2info.models.AdvancedRecyclerViewDataModel;
import io.zades.gw2info.models.AdvancedRecyclerViewParentDataModel;
import io.zades.gw2info.models.ParentNavigationModel;

/**
 * Created by zades on 12/4/2015.
 */
public abstract class AbstractAdvancedRecyclerViewAdapter<ParentData, ChildData> extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
	private static final String TAG = "AARVA";
	public static final int TYPE_PARENT = 999999;	//not so random high number

	private EventBus mEventBus = EventBus.getDefault();


	protected AdvancedRecyclerViewDataModel<ParentData, ChildData> mDataModel;

	public AbstractAdvancedRecyclerViewAdapter()
	{
		mEventBus.register(this);
		mDataModel = new AdvancedRecyclerViewDataModel<>();
	}

// Override these when you extend
//	@Override
//	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
//	{
//		return null;
//	}
//
//	@Override
//	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
//	{
//
//	}

	@Override
	public int getItemCount()
	{
		return mDataModel.getVisibleItemCount();
	}

	@Override
	public int getItemViewType(int position)
	{
		Pair<Integer, Integer> location = mDataModel.translatePosition(position);

		return mDataModel.getType(location.first, location.second);
	}

	public void onEvent(AdvancedRecyclerViewClickedEvent event)
	{
		AdvancedRecyclerViewParentDataModel<ParentData, ChildData> parent = mDataModel.getParent(event.getParentPosition());

		if(!parent.isCollapsed())
		{
			collapseParent(event.getParentPosition());
		}
		else
		{
			expandParent(event.getParentPosition());
		}
	}

	private void expandParent(int parentPosition)
	{
		AdvancedRecyclerViewParentDataModel<ParentData, ChildData> parent = mDataModel.getParent(parentPosition);

		//TODO: maybe check to make sure its a parent

		if(parent.isCollapsed())
		{
			Log.e(TAG, "Method expandParent evoked but parent already expanded");
			return;
		}

		parent.setIsCollapsed(false);
		notifyItemRangeInserted(parentPosition + 1, parent.getChildCount()); //TODO:convert numbers
	}

	private void collapseParent(int parentPosition)
	{
		AdvancedRecyclerViewParentDataModel<ParentData, ChildData> parent = mDataModel.getParent(parentPosition);

		//TODO: maybe check to make sure its a parent

		if(!parent.isCollapsed())
		{
			Log.e(TAG, "Method collapseParent evoked but parent already collapsed");
			return;
		}

		parent.setIsCollapsed(true);
		notifyItemRangeRemoved(parentPosition + 1, parent.getChildCount());	//TODO:convert numbers

	}
}
