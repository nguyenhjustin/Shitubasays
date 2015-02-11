package com.JHN.shitubasays;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RowQuoteAdapter extends ArrayAdapter<RowQuote> {
	private final Context context;
	private final ArrayList<RowQuote> rowQuoteArrayList;
	private int selected_position = -1;
	
	public RowQuoteAdapter(Context context, ArrayList<RowQuote> rowQuoteArrayList) {
		super(context, R.layout.row_view_quotes, rowQuoteArrayList);
		
		this.context = context;
		this.rowQuoteArrayList = rowQuoteArrayList;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// Create inflater
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		// Get rowView from inflater
		View rowView = inflater.inflate(R.layout.row_view_quotes, parent, false);
		
		// Get views from rowView
		ImageView img_view = (ImageView) rowView.findViewById(R.id.image_person);
		TextView quote_content_view = (TextView) rowView.findViewById(R.id.quote_content);
		TextView quote_name_view = (TextView) rowView.findViewById(R.id.quote_name);
		
		// Set the views
		img_view.setImageResource(rowQuoteArrayList.get(position).getImagePerson());
		quote_content_view.setText("\"" + rowQuoteArrayList.get(position).getQuote_content() + "\"");
		quote_name_view.setHint(rowQuoteArrayList.get(position).getQuote_name());
		
		// Expand/unexpand the quote if it's selected
//		if (position == selected_position && convertView != null) {
//			if (quote_content_view.getLayoutParams().height != LayoutParams.WRAP_CONTENT) {
//				quote_content_view.setHeight(LayoutParams.WRAP_CONTENT);
//				
//				LayoutParams layout_params = new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
//				rowView.setLayoutParams(layout_params);
//			}
//			else {
//				quote_content_view.setHeight(25);
//				LayoutParams layout_params = new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, 50);
//				rowView.setLayoutParams(layout_params);
//			}
//		}
		
		return rowView;
	}
	
	public void setSelectedPosition(int selected_pos) {
		selected_position = selected_pos;
	}
}
