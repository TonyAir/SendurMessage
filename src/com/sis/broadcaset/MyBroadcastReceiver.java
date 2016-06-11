package com.sis.broadcaset;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;

/**
 *  ¶¯Ì¬×¢²áBroadcase
 * @author Administrator
 *
 */



public class MyBroadcastReceiver extends Activity{
	private BroadcastReceiver receiver;
	@Override
	protected void onStart(){
		super.onStart();
		receiver = new MyReceiver();
		registerReceiver(receiver, new IntentFilter("android.intent.action.PHONE_STATE"));
	}
	@Override
	protected void onStop(){
		unregisterReceiver(receiver);
		super.onStop();
	}
}
