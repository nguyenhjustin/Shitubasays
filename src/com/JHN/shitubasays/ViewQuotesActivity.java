package com.JHN.shitubasays;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class ViewQuotesActivity extends ActionBarActivity {
	ArrayList<RowQuote> row_quotes;
	ListView list;
	RowQuoteAdapter row_adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_quotes);
		
		getQuotes();
		
		list = (ListView) findViewById(R.id.list);
		row_adapter = new RowQuoteAdapter(this, row_quotes);
		list.setAdapter(row_adapter);
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
	
	private void getQuotes() {
		row_quotes = new ArrayList<RowQuote>();
		row_quotes.add(new RowQuote("justin", "Shut the fuck up, Sid", "Justin"));
		row_quotes.add(new RowQuote("uclatubas", "We're good to go!", "UCLA Tubas"));
		row_quotes.add(new RowQuote("loren", "uh.. fucken..", "Loren"));
		row_quotes.add(new RowQuote("alex", "I respect the toilet. It's only for shitting and pissing", "Alex"));
		row_quotes.add(new RowQuote("darin", "BEEEEEEEEEEEEEF", "Darin"));
		row_quotes.add(new RowQuote("erick", "no balls, not down", "Erick"));
		row_quotes.add(new RowQuote("sam", "I'm reading about a rabbit that is Buddha", "Sam"));
		row_quotes.add(new RowQuote("esteban", "I bought this at the store", "Esteban"));
		row_quotes.add(new RowQuote("ivan", "tits pussy vagina penis dick ass", "Ivan"));
		row_quotes.add(new RowQuote("snips", "hey what time do we meet on the field?", "Snips"));
	}
}
