package io.zades.gw2info.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import io.zades.gw2info.R;
import io.zades.gw2info.events.PersonalBankItemClickedEvent;

/**
 * Created by zades on 12/4/2015.
 */
public class BankChildViewHolder extends AbstractAdvancedViewHolder
{
	public TextView textView;
	public ImageView imageView;

	private long mItemId;
	private Context mContext;

	public BankChildViewHolder(View itemView, Context context)
	{
		super(itemView);
		mContext = context;
		mItemId = -1;

		textView = (TextView) itemView.findViewById(R.id.text_bank_child_row);
		imageView = (ImageView) itemView.findViewById(R.id.image_bank_child_row);
	}

	public long getId()
	{
		return mItemId;
	}

	public void setId(long id)
	{
		mItemId = id;
	}

	@Override
	public void onClickPostAdvancedProcessing(View v)
	{
		this.getEventBus().post(new PersonalBankItemClickedEvent(mItemId));
	}
}
