package com.JHN.shitubasays;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.parse.ParseObject;

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
	
	public void SubmitQuote(View view) {
		EditText edit_quote = (EditText) findViewById(R.id.edit_quote);
		String quote = edit_quote.getText().toString();
		
		EditText edit_name = (EditText) findViewById(R.id.edit_name);
		String name = edit_name.getText().toString();
		
		ParseObject test = new ParseObject("Test");
		test.put("Quote", quote);
		test.put("Name", name);
		test.saveInBackground();
		
		NavUtils.navigateUpFromSameTask(this);
	}
}
