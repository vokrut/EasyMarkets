package com.kengoweb.easymarkets.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.kengoweb.easymarkets.R;
import com.kengoweb.easymarkets.appartments.Appartment;
import com.kengoweb.easymarkets.appartments.AppartmentFragment;
import com.kengoweb.easymarkets.appartments.AppartmentsFragment;
import com.kengoweb.easymarkets.filter.FilterFragment;

public class MainActivity extends AppCompatActivity implements AppartmentsFragment.OnListFragmentInteractionListener {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        showMainFragment();
    }

    private void showMainFragment() {
        Fragment fragment = new AppartmentsFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fl_fragment_container, fragment, AppartmentsFragment.TAG);
        transaction.commit();

        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true); // show back button
                    toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            onBackPressed();
                        }
                    });
                } else {
                    //show hamburger
                    getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                }
            }
        });
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
        if (id == R.id.action_filter) {
            return showFilterDialog();
        }

        return super.onOptionsItemSelected(item);
    }

    private boolean showFilterDialog() {
        Fragment fragment = new FilterFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.fl_fragment_container, fragment, FilterFragment.TAG);
        transaction.addToBackStack(FilterFragment.TAG);
        transaction.commit();
        return false;
    }

    @Override
    public void onListFragmentInteraction(Appartment item) {
        Fragment fragment = AppartmentFragment.newInstance(item);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.fl_fragment_container, fragment, AppartmentFragment.TAG);
        transaction.addToBackStack(AppartmentFragment.TAG);
        transaction.commit();
    }
}
