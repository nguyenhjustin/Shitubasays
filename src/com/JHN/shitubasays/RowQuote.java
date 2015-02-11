package com.JHN.shitubasays;

import java.util.*;

public class RowQuote {
	private String quote_name;
	private String quote_content;
	private Map<String, Object[]> image_person_map = MainApplication.getImagePersonMap();
	
	public RowQuote(String quote_name, String quote_content) {
		this.quote_name = quote_name;
		this.quote_content = quote_content;
	}

	public int getImagePerson() {
		String image_name = getQuote_name().toLowerCase();
		
		if (image_person_map.containsKey(image_name)) {
    		return (Integer)image_person_map.get(image_name)[1];
    	}
    	else {
    		return (Integer)image_person_map.get("generic")[1];
    	}	
	}
	
	public String getQuote_name() {
		if (quote_name.equalsIgnoreCase("degen") || quote_name.equalsIgnoreCase("jfague")) {
			return quote_name.substring(0, 2).toUpperCase() + quote_name.substring(2, quote_name.length());
		}
		else if (quote_name.equalsIgnoreCase("ucla tubas")) {
			return "UCLA Tubas";
		}

		return quote_name;
	}

	public void setQuote_name(String quote_name) {
		this.quote_name = quote_name;
	}

	public String getQuote_content() {
		return quote_content;
	}

	public void setQuote_content(String quote_content) {
		this.quote_content = quote_content;
	}
}