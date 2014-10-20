package com.JHN.shitubasays;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class SubmitQuoteActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_submit_quote);
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
		
		if (quote.length() == 0 || name.length() == 0) {
			TextView submit_status = (TextView) findViewById(R.id.submit_status);
			submit_status.setText("Please enter a quote and name.");
		}
		else {
			ParseObject test = new ParseObject("Test");
			test.put("Quote", quote);
			test.put("Name", name);
			
			final TextView submitting = new TextView(this);
			submitting.setText("Submitting...");
			submitting.setTextSize(22);
			submitting.setGravity(Gravity.CENTER);
			setContentView(submitting);
			
			test.saveInBackground(new SaveCallback() {
				@Override
				public void done(ParseException e) {
					if (e == null) {
						submitting.setText("Success!");
					}
					else {
						submitting.setText("Failed to submit. Make sure you're connected to the internet and try again.");
					}
				}
			});
		}
	}
	
	public void DoneSubmit() {
		NavUtils.navigateUpFromSameTask(this);
	}
}
