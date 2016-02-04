package io.zades.gw2info.fragments;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.zades.gw2info.R;
import io.zades.gw2info.adapters.BossTimeAdapter;
import io.zades.gw2info.adapters.NewsAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class BossTimeFragment extends Fragment
{
	private BroadcastReceiver mBraodcastReciever;

	private BossTimeAdapter mAdapter;
	private RecyclerView mRecyclerView;
	private RecyclerView.LayoutManager mLayoutManager;

	private long mStartTime;
	private Handler mHandler = new Handler();

	private Runnable mUpdateTimeTask = new Runnable()
	{
		@Override
		public void run()
		{
			final long start = mStartTime;
			long millis = SystemClock.uptimeMillis() - start;
			int seconds = (int) (millis / 1000);
			int minutes = seconds / 60;
			seconds = seconds % 60;

			mAdapter.refreshData(); //TODO: change to be less intensive?
			//Log.d("sdfd", "running per second loop");

			mHandler.postDelayed(mUpdateTimeTask, 100);
		}
	};

	public BossTimeFragment()
	{
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState)
	{
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_boss_time, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState)
	{
		super.onViewCreated(view, savedInstanceState);

		((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Boss Timers");

		mRecyclerView = (RecyclerView) getView().findViewById(R.id.recycler_view_boss_times);
		mLayoutManager = new LinearLayoutManager(getContext());

		mAdapter = new BossTimeAdapter(getContext());
		mRecyclerView.setAdapter(mAdapter);
		mRecyclerView.setLayoutManager(mLayoutManager);

		//start time things
		mStartTime = System.currentTimeMillis();
		mHandler.removeCallbacks(mUpdateTimeTask);
		mHandler.postDelayed(mUpdateTimeTask, 100);

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
//		mBraodcastReciever = new BroadcastReceiver()
//		{
//			@Override
//			public void onReceive(Context context, Intent intent)
//			{
//				if (intent.getAction().compareTo(Intent.ACTION_TIME_TICK) == 0)
//				{
//					mAdapter.refreshData();
//				}
//				Log.d("MTF", "broadcasted");
//			}
//		};
//
//		getActivity().registerReceiver(mBraodcastReciever, new IntentFilter(Intent.ACTION_TIME_TICK));
		//start time things
		mStartTime = System.currentTimeMillis();
		mHandler.removeCallbacks(mUpdateTimeTask);
		mHandler.postDelayed(mUpdateTimeTask, 100);

	}

	@Override
	public void onStop()
	{
		super.onStop();

		if(mHandler != null)
		{
			mHandler.removeCallbacks(mUpdateTimeTask);
		}

//		if(mBraodcastReciever != null)
//		{
//			getActivity().unregisterReceiver(mBraodcastReciever);
//		}
	}

}
