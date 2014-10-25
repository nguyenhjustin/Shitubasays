package com.JHN.shitubasays;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class ViewQuotesActivity extends ActionBarActivity {
	ArrayList<RowQuote> row_quotes;
	ListView list;
	RowQuoteAdapter row_adapter;
	ParseQuery<ParseObject> query;
	Date last_item_date;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		query = ParseQuery.getQuery("Test");
		
		TextView loading = new TextView(this);
		loading.setText("Loading...");
		loading.setTextSize(22);
		loading.setGravity(Gravity.CENTER);
		setContentView(loading);
		
		getQuotes(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_quotes, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		else if (id == R.id.action_search) {
        	return true;
        }
		return super.onOptionsItemSelected(item);
	}
	
	public void loadBackQuotes(View view) {
		
	}
	
	public void loadMoreQuotes(View view) {
		
	}
	
	private void getQuotes(final Context context) {
		row_quotes = new ArrayList<RowQuote>();
		
		query.whereExists("createdAt");
		query.orderByDescending("createdAt");
		//query.setLimit(10);
		
		query.findInBackground(new FindCallback<ParseObject>() {
			@Override
			public void done(List<ParseObject> quoteList, ParseException e) {
				if (e == null) {
					for (int i = 0; i < quoteList.size(); i++) {
						String quote = quoteList.get(i).getString("Quote");
						String name = quoteList.get(i).getString("Name");
						row_quotes.add(new RowQuote(name, quote, name));
						
						if (i == quoteList.size()-1) {
							last_item_date = quoteList.get(i).getCreatedAt();
						}
					}
				}
				else {
					row_quotes.add(new RowQuote("Justin", "hm, either you don't have internet connection or my database is down", "Justin"));
				}
				
				row_adapter = new RowQuoteAdapter(context, row_quotes);
				setContentView(R.layout.activity_view_quotes);
				list = (ListView) findViewById(R.id.list);
				list.setAdapter(row_adapter);
			}
		});
	}
}
