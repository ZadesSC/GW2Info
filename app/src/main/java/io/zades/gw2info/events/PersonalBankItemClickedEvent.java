package io.zades.gw2info.events;

import io.zades.gw2info.adapters.PersonalBankAdapter;

/**
 * Created by zades on 12/17/2015.
 */
public class PersonalBankItemClickedEvent
{
	private long mItemId;

	public PersonalBankItemClickedEvent(long id)
	{
		mItemId = id;
	}

	public long getItemId()
	{
		return mItemId;
	}
}
