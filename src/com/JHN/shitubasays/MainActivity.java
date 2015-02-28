package com.JHN.shitubasays;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.*;
import android.support.v4.view.ViewPager;
import android.view.View;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {
	ViewQuotesFragment frag_viewQuotes = new ViewQuotesFragment();
	HomeFragment frag_home = new HomeFragment();
	SubmitQuoteFragment frag_submitQuote = new SubmitQuoteFragment();
	
	AppSectionsPagerAdapter mAppSectionsPagerAdapter;
	ViewPager mViewPager;
	int numTabs = 3;
	final int VIEW = 0;
	final int HOME = 1;
	final int SUBMIT = 2;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        
        // Set up swipe screens
        mAppSectionsPagerAdapter = new AppSectionsPagerAdapter(getSupportFragmentManager());
        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        
        // Set up the ViewPager, attaching the adapter and setting up a listener for when the user swipes between sections.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mAppSectionsPagerAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });
        
        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mAppSectionsPagerAdapter.getCount(); i++) {
            // Create a tab with text corresponding to the page title defined by the adapter.
            // Also specify this Activity object, which implements the TabListener interface, as the
            // listener for when this tab is selected.
        	boolean selected = false;
        	
        	if (i == HOME) {
        		selected = true;
        	}
        	
            actionBar.addTab(actionBar.newTab()
                            .setText(mAppSectionsPagerAdapter.getPageTitle(i))
                            .setTabListener(this), selected);
        }
    }
    
    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }
    
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    	if (tab.getPosition() == SUBMIT) {
    		frag_submitQuote.Refresh();
    		mAppSectionsPagerAdapter.notifyDataSetChanged();
    	}
    	mViewPager.setCurrentItem(tab.getPosition());
    }
    
    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return super.onCreateOptionsMenu(menu);
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
    
    
    // Classes for swipe screen
  
    public class AppSectionsPagerAdapter extends FragmentStatePagerAdapter {
    
        public AppSectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
        	Fragment fragment = null;
        	
        	if (i == 0) {
        		fragment = frag_viewQuotes;
        	}
        	else if (i == 1) {
        		fragment = frag_home;
        	}
        	else if (i == 2) {
        		fragment = frag_submitQuote;
        	}
        	
        	return fragment;
        }

        @Override
        public int getCount() {
            return numTabs;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
	            case VIEW:
	            	return "Quotes";
	            case HOME:
	            	return "QotD";
	            case SUBMIT:
	            	return "Submit";
	            default: 
	            	return "";
            }
        }
    }
    
    public void OnClickButton(View v) {
    	switch(v.getId()) {
    		case R.id.button_submit:
    			frag_submitQuote.SubmitQuote(v);
    			break;
    		default:
    			break;
    	}
    }
    
}

