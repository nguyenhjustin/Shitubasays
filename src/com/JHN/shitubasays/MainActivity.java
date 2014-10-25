package com.JHN.shitubasays;

import java.util.HashMap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.parse.ParseException;
import com.parse.ParsePush;
import com.parse.SaveCallback;

public class MainActivity extends ActionBarActivity {
	public final static String QOTD = "com.JHN.shitubasays.QOTD";
	public static HashMap<String, Integer> image_person_map = MainApplication.image_person_map;
	public TextView qotd_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
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
             
    	qotd_content = (TextView) findViewById(R.id.qotd_content);
        qotd_content.setText("O wa ta di condois"); 
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
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
    
    public void viewQuotes(View view) {
    	Intent intent = new Intent(this, ViewQuotesActivity.class);
    	startActivity(intent);
    }
    
    public void addQuote(View view) {
    	Intent intent = new Intent(this, SubmitQuoteActivity.class);
    	startActivity(intent);
    }
    
    public static int getImageId(String name) {
    	name = name.substring(0, 1).toUpperCase() + name.substring(1);
    	
    	if (image_person_map.containsKey(name)) {
    		return image_person_map.get(name);
    	}
    	else {
    		return image_person_map.get("Generic");
    	}		
    }
}
