package io.zades.gw2info.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Pair;
import de.greenrobot.event.EventBus;
import io.zades.gw2info.events.AdvancedRecyclerViewClickedEvent;
import io.zades.gw2info.models.AdvancedRecyclerViewDataModel;
import io.zades.gw2info.models.AdvancedRecyclerViewParentDataModel;

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


	public void resetData()
	{
		mDataModel = new AdvancedRecyclerViewDataModel<>();
	}

	@Override
	public int getItemCount()
	{
		return mDataModel.getVisibleItemCount();
	}

	@Override
	public int getItemViewType(int position)
	{
		return mDataModel.getType(position);
	}

	public void onEvent(AdvancedRecyclerViewClickedEvent event)
	{
		Pair<Integer, Integer> pair = mDataModel.translatePosition(event.getPosition());
		AdvancedRecyclerViewParentDataModel<ParentData, ChildData> parent = mDataModel.getParent(pair.first);

		if(!parent.isCollapsed())
		{
			collapseParent(event.getPosition(), parent);
		}
		else
		{
			expandParent(event.getPosition(), parent);
		}
	}

	private void expandParent(int position, AdvancedRecyclerViewParentDataModel<ParentData,ChildData> parent)
	{
		//TODO: maybe check to make sure its a parent

		if(!parent.isCollapsed())
		{
			Log.e(TAG, "Method expandParent evoked but parent already expanded");
			return;
		}

		parent.setIsCollapsed(false);
		notifyItemRangeInserted(position + 1, parent.getChildCount()); //TODO:convert numbers
	}

	private void collapseParent(int position, AdvancedRecyclerViewParentDataModel<ParentData,ChildData> parent)
	{
		//TODO: maybe check to make sure its a parent

		if(parent.isCollapsed())
		{
			Log.e(TAG, "Method collapseParent evoked but parent already collapsed");
			return;
		}

		parent.setIsCollapsed(true);
		notifyItemRangeRemoved(position + 1, parent.getChildCount());	//TODO:convert numbers

	}
}
