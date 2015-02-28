package com.JHN.shitubasays;

import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.parse.ParsePushBroadcastReceiver;

public class ParsePushNotification extends ParsePushBroadcastReceiver {
	private String name = "";
	
	@Override
	protected Class<? extends Activity> getActivity(Context context, Intent intent) {
		return MainActivity.class;
	}
	
	@Override
	protected void onPushReceive(Context context, Intent intent) {
		JSONObject json;
		try {
			json = new JSONObject(intent.getExtras().getString("com.parse.Data"));
			name = json.getString("alert");
			name = name.substring(0, name.indexOf(":"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		super.onPushReceive(context, intent);
	}
	
	@Override
	protected void onPushOpen(Context context, Intent intent) {
		Intent i = new Intent(context, MainActivity.class);
		i.putExtras(intent.getExtras());
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(i);
	}
	
	@Override
	protected void onPushDismiss(Context context, Intent intent) {
		super.onPushDismiss(context, intent);
	}
	
	@SuppressLint("NewApi")
	@Override
	protected Notification getNotification(Context context, Intent intent) {
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
			Notification n = super.getNotification(context, intent).clone();
			n.largeIcon = getLargeIcon(context, intent);
			return n;
		}
		else {
			return super.getNotification(context, intent);
		}
	}
	
	@Override
	protected Bitmap getLargeIcon(Context context, Intent intent) {
		RowQuote rq = new RowQuote(name, "");
		Bitmap large_icon = BitmapFactory.decodeResource(context.getResources(), rq.getImagePerson());
		return large_icon;
	}
}
