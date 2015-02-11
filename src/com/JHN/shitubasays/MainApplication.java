package com.JHN.shitubasays;

import java.util.*;

import android.app.Application;
import android.content.Context;

import com.parse.Parse;
import com.parse.ParseInstallation;

public class MainApplication extends Application {
	private static MainApplication instance = new MainApplication();
	private static Map<String, Object[]> image_person_map;
	
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
    	image_person_map = new HashMap<String, Object[]>();
    	image_person_map.put("aaron", new Object[] {"Aaron", R.drawable.aaron}); 
    	image_person_map.put("aaron tannenbaum", new Object[] {"Aaron", R.drawable.aaron});
    	image_person_map.put("adan", new Object[] {"Adan", R.drawable.adan});
    	image_person_map.put("adan gonzalez", new Object[] {"Adan", R.drawable.adan});
    	image_person_map.put("alex", new Object[] {"Alex", R.drawable.alex});
    	image_person_map.put("alex nguyen", new Object[] {"Alex", R.drawable.alex});
    	image_person_map.put("andrew", new Object[] {"Sincuir", R.drawable.sincuir});
    	image_person_map.put("sincuir", new Object[] {"Sincuir", R.drawable.sincuir});
    	image_person_map.put("andrew sincuir", new Object[] {"Sincuir", R.drawable.sincuir});
    	image_person_map.put("spiderman", new Object[] {"Sincuir", R.drawable.sincuir});
    	image_person_map.put("andy", new Object[] {"Sprinkles", R.drawable.sprinkles});
    	image_person_map.put("sprenkel", new Object[] {"Sprinkles", R.drawable.sprinkles});
    	image_person_map.put("andy sprenkel", new Object[] {"Sprinkles", R.drawable.sprinkles});
    	image_person_map.put("sprinkles", new Object[] {"Sprinkles", R.drawable.sprinkles});
    	image_person_map.put("sprenkels", new Object[] {"Sprinkles", R.drawable.sprinkles});
    	image_person_map.put("anup", new Object[] {"Anup", R.drawable.anup});
    	image_person_map.put("anup kar", new Object[] {"Anup", R.drawable.anup});
    	image_person_map.put("briley", new Object[] {"Briley", R.drawable.briley});
    	image_person_map.put("briley cantwell", new Object[] {"Aaron", R.drawable.briley});
    	image_person_map.put("dj dymzz", new Object[] {"Briley", R.drawable.briley});
    	image_person_map.put("chris diaz", new Object[] {"Snips", R.drawable.snips});
    	image_person_map.put("snips", new Object[] {"Snips", R.drawable.snips});
    	image_person_map.put("chris", new Object[] {"Chris", R.drawable.chris});
    	image_person_map.put("chris torres", new Object[] {"Chris", R.drawable.chris});
    	image_person_map.put("clit", new Object[] {"Chris", R.drawable.chris});
    	image_person_map.put("clitoris", new Object[] {"Chris", R.drawable.chris});
    	image_person_map.put("christina", new Object[] {"Christina", R.drawable.christina});
    	image_person_map.put("christina kosters", new Object[] {"Christina", R.drawable.christina});
    	image_person_map.put("minnesota", new Object[] {"Christina", R.drawable.christina});
    	image_person_map.put("canada", new Object[] {"Christina", R.drawable.christina});
    	image_person_map.put("darin", new Object[] {"Darin", R.drawable.darin});
    	image_person_map.put("darin chun", new Object[] {"Darin", R.drawable.darin});
    	image_person_map.put("beef", new Object[] {"Darin", R.drawable.darin});
    	image_person_map.put("david", new Object[] {"DEgen", R.drawable.degen});
    	image_person_map.put("david egen", new Object[] {"DEgen", R.drawable.degen});
    	image_person_map.put("degen", new Object[] {"DEgen", R.drawable.degen});
    	image_person_map.put("erick", new Object[] {"Erick", R.drawable.erick});
    	image_person_map.put("erick corona", new Object[] {"Erick", R.drawable.erick});
    	image_person_map.put("generic", new Object[] {"", R.drawable.generic});
    	image_person_map.put("ivan", new Object[] {"Ivan", R.drawable.ivan});
    	image_person_map.put("ivan lam", new Object[] {"Ivan", R.drawable.ivan});
    	image_person_map.put("james", new Object[] {"Hummus", R.drawable.hummus});
    	image_person_map.put("james marquez", new Object[] {"Hummus", R.drawable.hummus});
    	image_person_map.put("hummus", new Object[] {"Hummus", R.drawable.hummus});
    	image_person_map.put("jason", new Object[] {"Jason", R.drawable.jason});
    	image_person_map.put("jason tom", new Object[] {"Jason", R.drawable.jason});
    	image_person_map.put("little bitch", new Object[] {"Jason", R.drawable.jason});
    	image_person_map.put("jing", new Object[] {"Jing", R.drawable.jing});
    	image_person_map.put("jing feng", new Object[] {"Jing", R.drawable.jing});
    	image_person_map.put("cunt", new Object[] {"Jing", R.drawable.jing});
    	image_person_map.put("joe fague", new Object[] {"JFague", R.drawable.jfague});
    	image_person_map.put("jfague", new Object[] {"JFague", R.drawable.jfague});
    	image_person_map.put("joe", new Object[] {"Joe", R.drawable.joe});
    	image_person_map.put("joe yi", new Object[] {"Joe", R.drawable.joe});
    	image_person_map.put("hawaii", new Object[] {"Joe", R.drawable.joe});
    	image_person_map.put("justin", new Object[] {"Justin", R.drawable.justin});
    	image_person_map.put("justin nguyen", new Object[] {"Justin", R.drawable.justin});
    	image_person_map.put("j-justin", new Object[] {"Justin", R.drawable.justin});
    	image_person_map.put("justout", new Object[] {"Justin", R.drawable.justin});
    	image_person_map.put("laura", new Object[] {"Laura", R.drawable.laura});
    	image_person_map.put("laura yraceburu", new Object[] {"Laura", R.drawable.laura});
    	image_person_map.put("loren", new Object[] {"Loren", R.drawable.loren});
    	image_person_map.put("loren quintanar", new Object[] {"Loren", R.drawable.loren});
    	image_person_map.put("mack", new Object[] {"Mack", R.drawable.mack});
    	image_person_map.put("mack dimler", new Object[] {"Mack", R.drawable.mack});
    	image_person_map.put("mackenzie", new Object[] {"Mack", R.drawable.mack});
    	image_person_map.put("may", new Object[] {"Mack", R.drawable.mack});
    	image_person_map.put("macklemore", new Object[] {"Mack", R.drawable.mack});
    	image_person_map.put("nicole", new Object[] {"Nicole", R.drawable.nicole});
    	image_person_map.put("nicole devries", new Object[] {"Nicole", R.drawable.nicole});
    	image_person_map.put("sam", new Object[] {"Sam", R.drawable.sam});
    	image_person_map.put("sam yang", new Object[] {"Sam", R.drawable.sam});
    	image_person_map.put("stephen mason", new Object[] {"Esteban", R.drawable.esteban});
    	image_person_map.put("esteban", new Object[] {"Esteban", R.drawable.esteban});
    	image_person_map.put("susie", new Object[] {"Susie", R.drawable.susie});
    	image_person_map.put("susie carlos", new Object[] {"Susie", R.drawable.susie});
    	image_person_map.put("ucla tubas", new Object[] {"UCLA Tubas", R.drawable.uclatubas});
    	image_person_map.put("vivian", new Object[] {"Vivian", R.drawable.vivian});
    	image_person_map.put("vivian liao", new Object[] {"Vivian", R.drawable.vivian});
    }
	
	public static Map<String, Object[]> getImagePersonMap() {
		return image_person_map;
	}
}
