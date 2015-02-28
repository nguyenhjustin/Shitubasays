package com.JHN.shitubasays;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.parse.CountCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParsePush;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeFragment extends Fragment {
	public final static String QOTD = "com.JHN.shitubasays.QOTD";
	ParseQuery<ParseObject> query;
	public TextView qotd_content;
	Random rand;
	
	@Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
		// Subscribe for push notifications
        ParsePush.subscribeInBackground("", new SaveCallback() {
        	@Override
        	public void done(ParseException e) {
        		if (e != null) {
        			// success
        		}
        		else {
        			// fail
        		}
        	}
        });
        
        // Generate pseudorandom number based on date
        DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        Date date = new Date();
        rand = new Random(Long.valueOf(dateFormat.format(date)));
        
        // Grab the random quote
        final Date today = new Date();
        today.setHours(0);
        today.setMinutes(0);
        today.setSeconds(0);
        
        query = ParseQuery.getQuery("Test");
        query.setLimit(1000);
        query.whereLessThan("createdAt", today);
        query.orderByAscending("createdAt");
        
        query.countInBackground(new CountCallback() {
        	@Override
        	public void done(int count, ParseException e) {
        		qotd_content = (TextView) getActivity().findViewById(R.id.qotd_content);
        		
        		if (e == null) {			
        			int i = rand.nextInt(count);
        			query.whereLessThan("createdAt", today);
        	        query.orderByAscending("createdAt");
        			query.setSkip(i);
        			
        			query.getFirstInBackground(new GetCallback<ParseObject>() {
        				  public void done(ParseObject object, ParseException e) {
        					  if (object != null) {
        						  String quote = object.getString("Quote");
        						  qotd_content.setText(quote); 
        					  } 
        					  else {
        						  qotd_content.setText("O wa ta di condois");
        				    }
        				  }
        			});
        	    } 
        		else {
        	    	qotd_content.setText("O wa ta di condois 2");
        	    }
        	}
        });
        
        return inflater.inflate(R.layout.home, container, false);
    }
}
