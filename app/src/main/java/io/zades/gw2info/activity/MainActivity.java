package io.zades.gw2info.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.widget.Toast;
import io.zades.gw2info.R;
import io.zades.gw2info.adapters.NavigationDrawerAdapter;

import static android.view.GestureDetector.*;

public class MainActivity extends AppCompatActivity
{

	private Toolbar mToolbar;
	private RecyclerView mRecyclerView;
	private RecyclerView.Adapter mAdapter;
	private RecyclerView.LayoutManager mLayoutManager;
	private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mToolbar = (Toolbar) findViewById(R.id.app_bar);
		setSupportActionBar(mToolbar);
		//getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView); // Assigning the RecyclerView Object to the xml View

		mRecyclerView.setHasFixedSize(true);                            // Letting the system know that the list objects are of fixed size

		mAdapter = new NavigationDrawerAdapter(this);       // Creating the Adapter of MyAdapter class(which we are going to see in a bit)
		// And passing the titles,icons,header view name, header view email,
		// and header view profile picture

		mRecyclerView.setAdapter(mAdapter);                              // Setting the adapter to RecyclerView
		mLayoutManager = new LinearLayoutManager(getApplicationContext());                 // Creating a layout Manager
		mRecyclerView.setLayoutManager(mLayoutManager);                 // Setting the layout Manager


		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);        // Drawer object Assigned to the view
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close)
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


	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings)
		{
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
