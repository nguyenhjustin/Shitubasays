package com.JHN.shitubasays;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

//public class ViewQuotesActivity extends ActionBarActivity {
public class ViewQuotesFragment extends Fragment {
	ArrayList<RowQuote> row_quotes;
	ListView list;
	RowQuoteAdapter row_adapter;
	ParseQuery<ParseObject> query;
	//Date last_item_date;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		query = ParseQuery.getQuery("Test");
		
		getQuotes(getActivity());
		View v = inflater.inflate(R.layout.view_quotes, container, false);
		
		// Set up SwipeRefreshLayout
        final SwipeRefreshLayout swipeView = (SwipeRefreshLayout) v.findViewById(R.id.swipe);
        swipeView.setColorScheme(android.R.color.transparent, android.R.color.holo_blue_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
        swipeView.setEnabled(false);
        ListView lView = (ListView) v.findViewById(R.id.list);
     
        swipeView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
            		swipeView.setRefreshing(true);
                
	                ( new Handler()).postDelayed(new Runnable() {
	                	
		                    @Override
		                    public void run() {
		                    	try {
		                    		query.cancel();
				                	getQuotes(getActivity()); 
		                    	} catch (Exception e) {
		                    		//System.out.println("JUSTIN LOOK HERE: ");
		                    		//e.printStackTrace();
		                    	}
		                    	
			                    swipeView.setRefreshing(false);
		                    }
		                }, 1500);
            }
        });
     
        lView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
     
            }
     
            @Override
            public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                    if (firstVisibleItem == 0)
                        swipeView.setEnabled(true);
                    else
                        swipeView.setEnabled(false);
            }
        });
        
        return v;
    }

	public void Refresh() {
		
	}
	
	public void loadBackQuotes(View view) {
		
	}
	
	public void loadMoreQuotes(View view) {
		
	}
	
	public void getQuotes(final Context context) {
		row_quotes = new ArrayList<RowQuote>();
		
		query.whereExists("createdAt");
		query.orderByDescending("createdAt");
		query.setLimit(1000);
		
		query.findInBackground(new FindCallback<ParseObject>() {
			@Override
			public void done(List<ParseObject> quoteList, ParseException e) {
				if (e == null) {
					for (int i = 0; i < quoteList.size(); i++) {
						String quote = quoteList.get(i).getString("Quote");
						String name = quoteList.get(i).getString("Name");
						row_quotes.add(new RowQuote(name, quote));
						
//						if (i == quoteList.size()-1) {
//							last_item_date = quoteList.get(i).getCreatedAt();
//						}
					}
				}
				else {
					row_quotes.add(new RowQuote("Justin", "hm, either you don't have internet connection or my database is down"));
				}
				
				row_adapter = new RowQuoteAdapter(context, row_quotes);
				list = (ListView) getActivity().findViewById(R.id.list);
				list.setAdapter(row_adapter);
			}
		});
	}

}
