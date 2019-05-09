package com.example.deya.navigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class HostActivity extends AppCompatActivity
        implements HomeFragment.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = HostActivity.class.getSimpleName();
    private static DrawerLayout drawer;
    private static android.support.v7.widget.Toolbar toolbar;
    private static NavigationView navigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            Log.d(TAG, "onCreate() Restoring previous state");
            /* restore state */
        } else {
            Log.d(TAG, "onCreate() No saved state available");
            /* initialize app */
        }
        setContentView(R.layout.activity_host);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        HomeFragment homeFragment = new HomeFragment();
        AboutFragment aboutFragment = new AboutFragment();
        fragmentTransaction.add(R.id.fragment_host, aboutFragment);
        fragmentTransaction.commit();
        fragmentTransaction.add(R.id.fragment_host, homeFragment);
        fragmentTransaction.commit();

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle =
                new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment newFragment;

        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                Log.i(TAG, "Home clicked");
                newFragment = new HomeFragment();
                break;

            case R.id.nav_about:
                Log.i(TAG, "About clicked");
                newFragment = new AboutFragment();
                break;

                default:
                    newFragment = new HomeFragment();
                    break;
        }
        drawer.closeDrawer(GravityCompat.START);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_host, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();

        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_bar_items, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast toast;

        switch (item.getItemId()) {
            case R.id.action_settings:
                Log.i(TAG,"Settings thrusters activated!!!");
                toast = Toast.makeText(this, getString(R.string.hello_blank_fragment), Toast.LENGTH_LONG);
                toast.show();
                return true;

            case R.id.action_report:
                Log.i(TAG, "REPORTED! You've been banned.");
                toast = Toast.makeText(this, getString(R.string.hello_blank_fragment), Toast.LENGTH_SHORT);
                toast.show();
                return true;

            case R.id.action_news:
                Log.i(TAG, "Huey Lewis");
                toast = Toast.makeText(this, getString(R.string.hello_blank_fragment), Toast.LENGTH_LONG);
                toast.show();
                return true;

                default:
                    return super.onOptionsItemSelected(item);
        }
    }

    public void swapFragments(Fragment fragment) {
        Fragment newFragment;

        if (fragment instanceof HomeFragment) {
            newFragment = new AboutFragment();
        } else {
            newFragment = new HomeFragment();
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_host, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void OnHomeFragmentClick(HomeFragment fragment) {
        swapFragments(fragment);
    }

}
