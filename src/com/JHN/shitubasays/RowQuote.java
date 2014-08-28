package com.JHN.shitubasays;

public class RowQuote {
	private String image_person;
	private String quote_content;
	private String quote_name;
	
	public RowQuote(String image_person, String quote_content, String quote_name) {
		this.image_person = image_person;
		this.quote_content = quote_content;
		this.quote_name = quote_name;
	}

	public int getImage_person() {
		return MainActivity.getImageId(image_person);
	}

	public void setImage_person(String image_person) {
		this.image_person = image_person;
	}

	public String getQuote_content() {
		return quote_content;
	}

	public void setQuote_content(String quote_content) {
		this.quote_content = quote_content;
	}

	public String getQuote_name() {
		return quote_name;
	}

	public void setQuote_name(String quote_name) {
		this.quote_name = quote_name;
	}
}