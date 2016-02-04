package io.zades.gw2info.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pkmmte.pkrss.Article;
import com.pkmmte.pkrss.Callback;
import com.pkmmte.pkrss.PkRSS;
import de.greenrobot.event.EventBus;
import io.zades.gw2info.R;
import io.zades.gw2info.adapters.NewsAdapter;
import io.zades.gw2info.events.NewsItemClickedEvent;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, Callback
{
	private static String GW2_NEWS_URL = "https://www.guildwars2.com/en/feed/";
	private final EventBus sEventBus = EventBus.getDefault();

	private NewsAdapter mAdapter;
	private RecyclerView mRecyclerView;
	private RecyclerView.LayoutManager mLayoutManager;
	private SwipeRefreshLayout mSwipeRefreshLayout;

	public NewsFragment()
	{
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState)
	{
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_news, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState)
	{
		super.onViewCreated(view, savedInstanceState);

		((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Guild Wars 2 News");

		mRecyclerView = (RecyclerView) getView().findViewById(R.id.recycler_view_news);
		mSwipeRefreshLayout = (SwipeRefreshLayout) getView().findViewById(R.id.refresh_news);
		mLayoutManager = new LinearLayoutManager(getContext());

		mAdapter = new NewsAdapter(getContext());
		mRecyclerView.setAdapter(mAdapter);
		mRecyclerView.setLayoutManager(mLayoutManager);
		mSwipeRefreshLayout.setOnRefreshListener(this);

		onRefresh(); //load data lazy way
	}

	@Override
	public void onResume()
	{
		super.onResume();
		sEventBus.register(this);
	}

	@Override
	public void onPause()
	{
		super.onPause();
		sEventBus.unregister(this);
	}

	//next 3 methods for for RSS library callbacks
	@Override
	public void onPreload()
	{
		mSwipeRefreshLayout.setRefreshing(true);
	}

	@Override
	public void onLoaded(List<Article> list)
	{
		mSwipeRefreshLayout.setRefreshing(false);
		//load data from rss
		mAdapter.refreshData(list);
	}

	@Override
	public void onLoadFailed()
	{
		mSwipeRefreshLayout.setRefreshing(false);
	}

	@Override
	public void onRefresh()
	{
		PkRSS.with(getActivity()).load(GW2_NEWS_URL).callback(this).async();
	}

	public void onEvent(NewsItemClickedEvent event)
	{
		Intent webIntent = new Intent(Intent.ACTION_VIEW, event.getUri());
		startActivity(webIntent);
	}
}
