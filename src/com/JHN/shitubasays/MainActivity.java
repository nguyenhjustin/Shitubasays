package com.JHN.shitubasays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.Parse;


public class MainActivity extends ActionBarActivity {
	public final static String QOTD = "com.JHN.shitubasays.QOTD";
	public static HashMap<String, Integer> image_person_map;
	public TextView qotd_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        setupImagePersonMap();
        
        qotd_content = (TextView) findViewById(R.id.qotd_content);
        qotd_content.setText("O wa ta di condois");
        
        //String URL = "http://services.runescape.com/m=itemdb_rs/api/catalogue/detail.json?item=4798";
        //new HttpAsyncTask().execute(URL);
        
        Parse.initialize(this, "ZgPcDlXeN2WfUOhXI4Rb7XHQb4Dyp4lSdS7pLJ2C", "YT2yxdpiX5EIBKscUdKYCrHE2TWThTSWVpyEWZyn");
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
    	if (image_person_map.containsKey(name)) {
    		return image_person_map.get(name);
    	}
    	else {
    		return image_person_map.get("Generic");
    	}		
    }
    
    private void setupImagePersonMap() {
    	image_person_map = new HashMap<String, Integer>();
    	image_person_map.put("Justin", R.drawable.justin);
    	image_person_map.put("Alex", R.drawable.alex);
    	image_person_map.put("Darin", R.drawable.darin);
    	image_person_map.put("Erick", R.drawable.erick);
    	image_person_map.put("Ivan", R.drawable.ivan);
    	image_person_map.put("Sam", R.drawable.sam);
    	image_person_map.put("Esteban", R.drawable.esteban);
    	image_person_map.put("Loren", R.drawable.loren);
    	image_person_map.put("Uclatubas", R.drawable.uclatubas);
    	image_person_map.put("Snips", R.drawable.snips);
    	image_person_map.put("Generic", R.drawable.generic);
    }
    
//    public static String GET(String url) {
//    	InputStream inputStream = null;
//    	String result = "";
//    	
//    	try {
//    		HttpClient client = new DefaultHttpClient();
//    		HttpResponse response = client.execute(new HttpGet(url));
//    		inputStream = response.getEntity().getContent();
//    		if (inputStream != null) {
//    			result = ConvertInputStreamToString(inputStream);
//    		}
//    		else {
//    			result = "Did not work!";
//    		}
//    	}
//    	catch (Exception e) {
//    		
//    	}
//    	
//    	return result;
//    }
//    
//    private static String ConvertInputStreamToString(InputStream inputStream) throws IOException {
//    	BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//    	String line = "";
//    	String result = "";
//    	while ((line = reader.readLine()) != null) {
//    		result += line;
//    	}
//    	inputStream.close();
//    	return result;
//    }
//    
//    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
//    	@Override
//    	protected String doInBackground(String... urls) {
//    		return GET(urls[0]);
//    	}
//    	
//    	@Override
//    	protected void onPostExecute(String result) {
//    		Toast.makeText(getBaseContext(), "Received!", Toast.LENGTH_LONG).show();
//    		content.setText(result);
//    	}
//    }
}
