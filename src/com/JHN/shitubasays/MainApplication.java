package com.JHN.shitubasays;

import java.util.HashMap;

import com.parse.Parse;
import com.parse.ParseInstallation;

import android.app.Application;
import android.content.Context;

public class MainApplication extends Application {
	private static MainApplication instance = new MainApplication();
	public static HashMap<String, Integer> image_person_map;
	
	public MainApplication() {
		instance = this;
	}
	
	public static Context getContext() {
		return instance;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		// Initialize Parse database
		Parse.initialize(this, "ZgPcDlXeN2WfUOhXI4Rb7XHQb4Dyp4lSdS7pLJ2C", "YT2yxdpiX5EIBKscUdKYCrHE2TWThTSWVpyEWZyn");
		ParseInstallation.getCurrentInstallation().saveInBackground();
		
		// Map names to images
		setupImagePersonMap();
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
    	image_person_map.put("UCLA Tubas", R.drawable.uclatubas);
    	image_person_map.put("Snips", R.drawable.snips);
    	image_person_map.put("Generic", R.drawable.generic);
    	image_person_map.put("Laura", R.drawable.laura);
    	image_person_map.put("Jing", R.drawable.jing);
    	image_person_map.put("Jason", R.drawable.jason);
    	image_person_map.put("Briley", R.drawable.briley);
    	image_person_map.put("Anup", R.drawable.anup);
    	image_person_map.put("Chris", R.drawable.chris);
    	image_person_map.put("Christina", R.drawable.christina);
    	image_person_map.put("James", R.drawable.james);
    	image_person_map.put("Jfague", R.drawable.jfague);
    	image_person_map.put("Joe", R.drawable.joe);
    	image_person_map.put("Mack", R.drawable.mack);
    	image_person_map.put("Nicole", R.drawable.nicole);
    	image_person_map.put("Sincuir", R.drawable.sincuir);
    	image_person_map.put("Sprenkels", R.drawable.sprenkels);
    	image_person_map.put("Susie", R.drawable.susie);
    	image_person_map.put("Vivian", R.drawable.vivian);
    	image_person_map.put("Aaron", R.drawable.aaron);
    	image_person_map.put("Adan", R.drawable.adan);
    	image_person_map.put("David",  R.drawable.david);
    }
}
