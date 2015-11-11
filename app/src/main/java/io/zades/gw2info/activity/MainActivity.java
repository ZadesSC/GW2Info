package io.zades.gw2info.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import io.zades.gw2info.R;
import io.zades.gw2info.fragments.NavigationDrawerFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private NavigationDrawerFragment mNavigationDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mToolbar = (Toolbar) this.findViewById(R.id.app_bar);
        if(this.mToolbar != null) this.setSupportActionBar(this.mToolbar);

        this.mNavigationDrawerFragment = (NavigationDrawerFragment)
                this.getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        this.mNavigationDrawerFragment.setUp((DrawerLayout)this.findViewById(R.id.drawer_layout), this.mToolbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
