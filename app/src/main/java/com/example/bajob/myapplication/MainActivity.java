package com.example.bajob.myapplication;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.bajob.myapplication.fragments.DuoFragment;
import com.example.bajob.myapplication.fragments.ThreeFragment;
import com.example.bajob.myapplication.fragments.UnoFragment;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbaar);
        setSupportActionBar(toolbar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_one_title));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_two_title));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_three_title));
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        adapter = new CustomAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(fab,"some text",Snackbar.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.podesavanja) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private static class CustomAdapter extends FragmentPagerAdapter {
        private static String[] titles = new String[]{"Uno", "Duo", "Three"};
        public CustomAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment result = null;
            switch (position) {
                case 0:
                    result = new UnoFragment();
                    break;
                case 1:
                    result = new DuoFragment();
                    break;
                case 2:
                    result = new ThreeFragment();
                    break;
                default:
                    break;
            }
            return result;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }

}



