package com.JHN.shitubasays;

import java.util.ArrayList;
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
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
	
	private void getQuotes(final Context context) {
		row_quotes = new ArrayList<RowQuote>();
//		row_quotes.add(new RowQuote("Justin", "Shut the fuck up, Sid", "Justin"));
//		row_quotes.add(new RowQuote("Uclatubas", "We're good to go!", "UCLA Tubas"));
//		row_quotes.add(new RowQuote("Loren", "uh.. fucken..", "Loren"));
//		row_quotes.add(new RowQuote("Alex", "I respect the toilet. It's only for shitting and pissing", "Alex"));
//		row_quotes.add(new RowQuote("Darin", "BEEEEEEEEEEEEEF", "Darin"));
//		row_quotes.add(new RowQuote("Erick", "no balls, not down", "Erick"));
//		row_quotes.add(new RowQuote("Sam", "I'm reading about a rabbit that is Buddha", "Sam"));
//		row_quotes.add(new RowQuote("Esteban", "I bought this at the store", "Esteban"));
//		row_quotes.add(new RowQuote("Ivan", "tits pussy vagina penis dick ass", "Ivan"));
//		row_quotes.add(new RowQuote("Snips", "hey what time do we meet on the field?", "Snips"));
		
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Test");
		query.whereExists("createdAt");
		query.orderByDescending("createdAt");
		query.setLimit(10);
		
		query.findInBackground(new FindCallback<ParseObject>() {
			@Override
			public void done(List<ParseObject> quoteList, ParseException e) {
				if (e == null) {
					for (int i = 0; i < quoteList.size(); i++) {
						String quote = quoteList.get(i).getString("Quote");
						String name = quoteList.get(i).getString("Name");
						name = name.substring(0, 1).toUpperCase() + name.substring(1);
						row_quotes.add(new RowQuote(name, quote, name));
					}
				}
				else {
					row_quotes.add(new RowQuote("Justin", "hm, either you don't have internet connection or my database is down", "Justin"));
				}
				
				row_adapter = new RowQuoteAdapter(context, row_quotes);
				setContentView(R.layout.activity_view_quotes);
				list = (ListView) findViewById(R.id.list);
				list.setAdapter(row_adapter);
				setupListViewListener();
			}
		});
	}
	
	public void setupListViewListener() {
		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				//RowQuoteAdapter row = (RowQuoteAdapter) list.getItemAtPosition(position);
				
			}	
		});
	}
}
