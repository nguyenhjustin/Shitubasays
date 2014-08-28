package com.JHN.shitubasays;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;

public class SubmitQuoteActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_submit_quote);
		
		// Get the message from the intent
		//Intent intent = getIntent();
		//String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		
		// Create the text view
		//TextView textView = new TextView(this);
		//textView.setTextSize(40);
		//textView.setText(message);
		
		// Set the text view as the activity layout
		//setContentView(textView);
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
		return super.onOptionsItemSelected(item);
	}
	
	public void submitQuote(View view) {
		// TODO: Send quote and name to server
		
		NavUtils.navigateUpFromSameTask(this);
	}
}