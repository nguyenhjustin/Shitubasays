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
import com.parse.ParsePush;
import com.parse.SaveCallback;

public class SubmitQuoteActivity extends ActionBarActivity {
	private ParseObject parse_obj = new ParseObject("Test");
	private ParsePush parse_push = new ParsePush();
	
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
		// Get the quote string
		EditText edit_quote = (EditText) findViewById(R.id.edit_quote);
		final String quote = edit_quote.getText().toString();
		
		// Get the name string
		EditText edit_name = (EditText) findViewById(R.id.edit_name);
		final String name = edit_name.getText().toString();
		
		// Prevent submitting an empty quote or name
		if (quote.length() == 0 || name.length() == 0) {
			TextView submit_status = (TextView) findViewById(R.id.submit_status);
			submit_status.setText("Please enter a quote and name.");
		}
		else {
			parse_obj.put("Quote", quote);
			parse_obj.put("Name", name);
			
			// Display submitting screen
			final TextView submitting = new TextView(this);
			submitting.setText("Submitting...");
			submitting.setTextSize(22);
			submitting.setGravity(Gravity.CENTER);
			setContentView(submitting);
			
			parse_obj.saveInBackground(new SaveCallback() {
				@Override
				public void done(ParseException e) {
					if (e == null) {
						submitting.setText("Success!");
						
						String push_message = name + ": " + quote;
						if (push_message.length() > 40) {
							push_message = push_message.substring(0, 40) + "...";
						}
						
						parse_push.setChannel("");
						parse_push.setMessage(push_message);
						parse_push.sendInBackground();
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
