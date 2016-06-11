package com.sis.broadcaset;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendMessageActivity extends Activity {
    
    private EditText phone_number_editText;
    private EditText sms_content_editText;
    private Button send_sms_button;
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.send_message);
	        
	        phone_number_editText = (EditText) findViewById(R.id.phone_number_editText);
	        sms_content_editText = (EditText) findViewById(R.id.sms_content_editText);
	        send_sms_button = (Button) findViewById(R.id.send_sms_button);
	        send_sms_button.setOnClickListener(new OnClickListener() {
	            @Override
	            public void onClick(View arg0) {
	                String phone_number = phone_number_editText.getText().toString().trim();
	                String sms_content = sms_content_editText.getText().toString().trim();
	                if(phone_number.equals("")) {
	                    Toast.makeText(SendMessageActivity.this, R.string.str_remind_input_phone_number, Toast.LENGTH_LONG).show();
	                } else {
	                    SmsManager smsManager = SmsManager.getDefault();
	                    if(sms_content.length() > 70) {
	                        List<String> contents = smsManager.divideMessage(sms_content);
	                        for(String sms : contents) {
	                            smsManager.sendTextMessage(phone_number, null, sms, null, null);
	                        }
	                    } else {
	                     smsManager.sendTextMessage(phone_number, null, sms_content, null, null);
	                    }
	                    Toast.makeText(SendMessageActivity.this, R.string.str_remind_sms_send_finish, Toast.LENGTH_SHORT).show();
	                }
	            }     
	        });
	    }

}
