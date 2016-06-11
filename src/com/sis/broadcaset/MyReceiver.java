package com.sis.broadcaset;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

	/**
	 * 动态注册Broadcase 的Receiver接收类
	 * 
	 * @author Administrator
	 * 
	 */
	@Override
	public void onReceive(Context context, Intent intent) {
		//
		Toast.makeText(context, "this is receiver", Toast.LENGTH_SHORT).show();
	}

}
