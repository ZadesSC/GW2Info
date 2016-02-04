package io.zades.gw2info.events;

import android.net.Uri;

/**
 * Created by zades on 1/18/2016.
 */
public class NewsItemClickedEvent
{
	private Uri mUri;

	public NewsItemClickedEvent(Uri uri)
	{
		mUri = uri;
	}

	public Uri getUri()
	{
		return mUri;
	}
}
