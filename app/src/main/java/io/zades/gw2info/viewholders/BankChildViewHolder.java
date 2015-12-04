package io.zades.gw2info.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import io.zades.gw2info.R;

/**
 * Created by zades on 12/4/2015.
 */
public class BankChildViewHolder extends RecyclerView.ViewHolder
{
	public TextView textView;
	public ImageView imageView;

	private Context mContext;

	public BankChildViewHolder(View itemView, Context context)
	{
		super(itemView);
		mContext = context;

		textView = (TextView) itemView.findViewById(R.id.text_bank_child_row);
		imageView = (ImageView) itemView.findViewById(R.id.image_bank_child_row);
	}
}
