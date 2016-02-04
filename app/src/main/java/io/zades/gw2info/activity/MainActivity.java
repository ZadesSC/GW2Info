package io.zades.gw2info.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.*;
import io.zades.gw2info.R;
import io.zades.gw2info.fragments.NavigationDrawerFragment;

public class MainActivity extends AppCompatActivity
{

	private Toolbar mToolbar;
	private NavigationDrawerFragment mDrawerFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mToolbar = (Toolbar) findViewById(R.id.app_bar);
		mToolbar.getMenu().clear();
		setSupportActionBar(mToolbar);

		mDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.menu_main, menu);
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
