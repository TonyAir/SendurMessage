package com.sis.broadcaset;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SmsShield extends Activity {
	Button beginButton;
	Button stopButton;
	Button sendMsgButton;
	Button dbButton = null;
	SmsReceiver receiver = null;

	boolean isRegisted = false;

	static final String ACTION = "android.provider.Telephony.SMS_RECEIVED";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		beginButton = (Button) findViewById(R.id.beginButton);
		stopButton = (Button) findViewById(R.id.stopButton);
		sendMsgButton = (Button) findViewById(R.id.sendButton);
		dbButton = (Button) findViewById(R.id.dbButton);
		beginButton.setEnabled(true);
		stopButton.setEnabled(false);
		beginButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				regist();
				beginButton.setEnabled(false);
				stopButton.setEnabled(true);
			}
		});
		stopButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				unRegist();
				beginButton.setEnabled(true);
				stopButton.setEnabled(false);
			}
		});
		sendMsgButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SmsShield.this,
						SendMessageActivity.class);
				startActivity(intent);
			}
		});
		dbButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SmsShield.this,
						TrainingDBActivity.class);
				startActivity(intent);
			}
		});
	}

	// 销毁时注销receiver
	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (receiver != null && isRegisted) {
			unregisterReceiver(receiver);
			isRegisted = false;
		}
	}

	// 注册receiver
	public void regist() {
		IntentFilter filter = new IntentFilter(ACTION);
		filter.setPriority(1000);
		receiver = new SmsReceiver();
		registerReceiver(receiver, filter);
		isRegisted = true;
	}

	// 注销receiver
	public void unRegist() {
		if (receiver != null && isRegisted) {
			unregisterReceiver(receiver);
			isRegisted = false;
		}
	}
}
