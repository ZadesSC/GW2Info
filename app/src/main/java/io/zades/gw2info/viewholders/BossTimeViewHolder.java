package io.zades.gw2info.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import io.zades.gw2info.R;

/**
 * Created by zades on 2/4/2016.
 */
public class BossTimeViewHolder extends RecyclerView.ViewHolder
{

	public TextView mTextBossTitle;
	public TextView mTextBossTime;

	public BossTimeViewHolder(View itemView)
	{
		super(itemView);

		mTextBossTitle = (TextView) itemView.findViewById(R.id.text_boss_title);
		mTextBossTime = (TextView) itemView.findViewById(R.id.text_boss_time);
	}
}
