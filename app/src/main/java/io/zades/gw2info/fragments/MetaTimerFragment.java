package io.zades.gw2info.fragments;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.LinearLayout;
import android.widget.TextView;
import io.zades.gw2info.R;
import io.zades.gw2info.views.TimedMetaEventView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MetaTimerFragment extends Fragment
{
	private TimedMetaEventView mMetaEventView;
	private BroadcastReceiver mBraodcastReciever;

	public MetaTimerFragment()
	{
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState)
	{
		// Inflate the layout for this fragment
		View v = inflater.inflate(R.layout.fragment_meta_timer, container, false);
		return v;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState)
	{
		super.onViewCreated(view, savedInstanceState);

		((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Meta Timers");

		mMetaEventView = (TimedMetaEventView) getView().findViewById(R.id.timed_meta_view);
		if(mMetaEventView == null)
		{
			Log.d("MTF", "null");
		}

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);

	}

	@Override
	public void onStart()
	{
		super.onStart();
		mBraodcastReciever = new BroadcastReceiver()
		{
			@Override
			public void onReceive(Context context, Intent intent)
			{
				if (intent.getAction().compareTo(Intent.ACTION_TIME_TICK) == 0)
				{
					mMetaEventView.updateTime();
				}
				Log.d("MTF", "broadcasted");
			}
		};

		getActivity().registerReceiver(mBraodcastReciever, new IntentFilter(Intent.ACTION_TIME_TICK));

	}

	@Override
	public void onStop()
	{
		super.onStop();

		if(mBraodcastReciever != null)
		{
			getActivity().unregisterReceiver(mBraodcastReciever);
		}
	}

}
