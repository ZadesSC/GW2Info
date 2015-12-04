package io.zades.gw2info.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.h6ah4i.android.widget.advrecyclerview.animator.GeneralItemAnimator;
import com.h6ah4i.android.widget.advrecyclerview.animator.RefactoredDefaultItemAnimator;
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;
import io.zades.gw2info.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalBankFragment extends Fragment implements RecyclerViewExpandableItemManager.OnGroupCollapseListener, RecyclerViewExpandableItemManager.OnGroupExpandListener
{
	private Toolbar mToolbar;
	private RecyclerView mRecyclerView;
	private RecyclerView.Adapter mAdapter;
	private RecyclerView.LayoutManager mLayoutManager;
	private ActionBarDrawerToggle mDrawerToggle;

	public PersonalBankFragment()
	{
		super();
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_personal_bank, container, false);
		return view;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState)
	{
		super.onViewCreated(view, savedInstanceState);

		mToolbar = (Toolbar) getActivity().findViewById(R.id.app_bar);
		mRecyclerView = (RecyclerView) getView().findViewById(R.id.recycle_view_navigation_drawer);
		mLayoutManager = new LinearLayoutManager(getContext());

		//init mAdapter

		mRecyclerView.setHasFixedSize(false);
		mRecyclerView.setAdapter(mAdapter);
		//mRecyclerView.setItemAnimator(animator);
		mRecyclerView.setLayoutManager(mLayoutManager);


	}

	@Override
	public void onGroupCollapse(int i, boolean b)
	{

	}

	@Override
	public void onGroupExpand(int i, boolean b)
	{

	}
}
