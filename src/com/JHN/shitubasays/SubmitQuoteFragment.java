package com.JHN.shitubasays;

import java.util.*;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParsePush;
import com.parse.SaveCallback;

public class SubmitQuoteFragment extends Fragment {
	private ParseObject parse_obj = new ParseObject("Test");
	private ParsePush parse_push = new ParsePush();
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.submit_quote, container, false);
    }
	
	public void Refresh() {
		if (getView() != null) {
			TextView submit_status = (TextView) getView().findViewById(R.id.submit_status);
			submit_status.setText("");
		}
	}
	
	public void SubmitQuote(View view) {
		// Hide the keyboard
		Activity a;
		
		if ((a = getActivity()) != null) {
			InputMethodManager inputManager = (InputMethodManager) a.getSystemService(Context.INPUT_METHOD_SERVICE);
			
			if (a.getCurrentFocus() == null) {
				inputManager.hideSoftInputFromWindow(null, InputMethodManager.HIDE_NOT_ALWAYS);
			}
			else {
				inputManager.hideSoftInputFromWindow(a.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
			}
		}
		
		// Get the quote string
		final EditText edit_quote = (EditText) getView().findViewById(R.id.edit_quote);
		String temp_quote = edit_quote.getText().toString();
		final String quote = ParseQuote(temp_quote);
		
		// Get the name string
		final EditText edit_name = (EditText) getView().findViewById(R.id.edit_name);
		String temp_name = edit_name.getText().toString();
		temp_name = ParseName(temp_name);
		
		Map<String, Object[]> image_person_map = MainApplication.getImagePersonMap();
		
		// Prevent submitting an empty quote or name
		final TextView submit_status = (TextView) getView().findViewById(R.id.submit_status);
		submit_status.setTextColor(Color.parseColor("#ff0f00")); // RED
		
		if (quote.length() == 0 || temp_name.length() == 0) {
			submit_status.setText("Please enter a quote and name.");
		}
		// Check if name is in the mapping
		else if (!image_person_map.containsKey(temp_name)) {
			submit_status.setText("Please try a different name.");
    	}
		// For testing purposes
//		else {
//			final String name = (String)image_person_map.get(temp_name)[0];
//			submit_status.setText("Quote: " + quote + "\nName: " + name);
//		}
		else {
			final String name = (String)image_person_map.get(temp_name)[0];
			parse_obj.put("Quote", quote);
			parse_obj.put("Name", name);
			
			// Display submitting screen
			submit_status.setTextColor(Color.parseColor("#000000")); // BLACK
			submit_status.setText("Submitting...");
			
			parse_obj.saveInBackground(new SaveCallback() {
				@Override
				public void done(ParseException e) {
					if (e == null) {
						String push_message = name + ": " + quote;
						if (push_message.length() > 40) {
							push_message = push_message.substring(0, 40) + "...";
						}
						
						parse_push.setChannel("");
						parse_push.setMessage(push_message);
						parse_push.sendInBackground();
					
						edit_quote.setText("");
						edit_name.setText("");
						submit_status.setTextColor(Color.parseColor("#2eb7ed")); // BLUE
						submit_status.setText("Success!");
					}
					else {
						submit_status.setTextColor(Color.parseColor("#ff0f00")); // RED
						submit_status.setText("Failed to submit. Make sure you're connected to the internet and try again.");
					}
				}
			});
		}
	}
	
	private String ParseQuote(String quote) {
		quote.trim();
		
		// Ignore quotes inserted by the users themselves
		if (quote.length() >= 2) {
			if ( (quote.startsWith("'") || quote.startsWith("\"")) && (quote.endsWith("'") || quote.endsWith("\"")) ) {
				quote = quote.substring(1, quote.length()-1);
			}
		}
		
		if (quote.length() >= 1) {
			quote = quote.substring(0, 1).toUpperCase() + quote.substring(1, quote.length());
		}

		return quote;
	}
	
	private String ParseName(String name) {
		name.trim().toLowerCase();
		return name;
	}
}
