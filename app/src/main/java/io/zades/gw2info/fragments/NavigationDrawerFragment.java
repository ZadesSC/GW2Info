package io.zades.gw2info.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.greenrobot.event.EventBus;
import io.zades.gw2info.R;
import io.zades.gw2info.adapters.NavigationDrawerAdapter;
import io.zades.gw2info.events.NavigationItemClickedEvent;

/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationDrawerFragment extends Fragment
{
	private static final String TAG = "NavigationFragment";

	private EventBus mEventBus = EventBus.getDefault();
	private Toolbar mToolbar;
	private RecyclerView mRecyclerView;
	private RecyclerView.Adapter mAdapter;
	private RecyclerView.LayoutManager mLayoutManager;
	private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;

	public NavigationDrawerFragment()
	{
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);

		mRecyclerView = (RecyclerView) view.findViewById(R.id.recycle_view_navigation_drawer);

		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);

		mEventBus.register(this);

		mToolbar = (Toolbar) getActivity().findViewById(R.id.app_bar);
		mDrawerLayout = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);

		mRecyclerView.setHasFixedSize(false);                            // Letting the system know that the list objects are of fixed size
		mAdapter = new NavigationDrawerAdapter(getContext());       // Creating the Adapter of MyAdapter class(which we are going to see in a bit)

		mRecyclerView.setAdapter(mAdapter);                              // Setting the adapter to RecyclerView
		mLayoutManager = new LinearLayoutManager(getContext());                 // Creating a layout Manager
		mRecyclerView.setLayoutManager(mLayoutManager);                 // Setting the layout Manager

		mDrawerToggle = new ActionBarDrawerToggle(getActivity(), mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close)
		{

			@Override
			public void onDrawerOpened(View drawerView)
			{
				super.onDrawerOpened(drawerView);
				// code here will execute once the drawer is opened( As I dont want anything happened whe drawer is
				// open I am not going to put anything here)
			}

			@Override
			public void onDrawerClosed(View drawerView)
			{
				super.onDrawerClosed(drawerView);
				// Code here will execute once drawer is closed
			}


		}; // Drawer Toggle Object Made
		mDrawerLayout.setDrawerListener(mDrawerToggle); // Drawer Listener set to the Drawer toggle
		mDrawerToggle.syncState();
	}

	public void onEvent(NavigationItemClickedEvent event)
	{
		Fragment fragment = null;
		Class fragmentClass = null;

		switch (event.getChildTitle())
		{
			case "Bank":
				fragmentClass = PersonalBankFragment.class;
				break;
			default:
				fragmentClass = PersonalBankFragment.class;
				break;
		}

		try
		{
			fragment = (Fragment) fragmentClass.newInstance();
		} catch (java.lang.InstantiationException e)
		{
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}

		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager.beginTransaction().replace(R.id.frame_layout_content, fragment).commit();

		Log.d(TAG, "Reached onEvent reached for NavigationItemClickedEvent");

	}


}
