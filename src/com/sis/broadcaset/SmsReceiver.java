package com.sis.broadcaset;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.telephony.SmsManager;
import android.telephony.gsm.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import com.zzm.db.DBOpenHelper;

public class SmsReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// 获得短信的内容
		Object [] pdus = (Object[]) intent.getExtras().get("pdus");
		if (pdus != null && pdus.length>0) {
			SmsMessage[] messages = new SmsMessage[pdus.length];
			for (int i = 0; i < pdus.length; i++) {
				byte[] pdu = (byte[]) pdus[i];
				messages[i]=SmsMessage.createFromPdu(pdu);
			}
			// 遍历新短信
			for (SmsMessage message : messages) {
				String sender = message.getOriginatingAddress();
				String content = message.getDisplayMessageBody();
				if (!sender.isEmpty() && !content.isEmpty()) {
					Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
                    SmsManager smsManager = SmsManager.getDefault();
                    String sendToNum = sender;
                    String contentText = "1";
    				contentText = makeContent(content,context);
                    smsManager.sendTextMessage(sendToNum, null, contentText, null, null);
                    Toast.makeText(context, R.string.str_remind_sms_send_finish+"!"+"the content is:"+contentText, Toast.LENGTH_SHORT).show();
					abortBroadcast();
				}else {
					Toast.makeText(context, R.string.str_remind_sms_send_losed, Toast.LENGTH_SHORT).show();
				}
			}
		}
	}
	private String makeContent(String keyword,Context context){
		String result = "noMessage";
		DBOpenHelper helper = new DBOpenHelper(context, "talktb.db");
		SQLiteDatabase db = helper.getWritableDatabase();
		// 根据keyword 查询
		Cursor c = db.rawQuery("select detail from talktb where keyword like ? ", new String[]{keyword}); 
		if (c!=null) {
			String [] cols = c.getColumnNames();
			while (c.moveToNext()) {
				for (String ColumnName : cols) {
					Log.i("info", ColumnName+":"+c.getString(c.getColumnIndex(ColumnName)));
					 if ("detail".equals(ColumnName)) {
						 result = c.getString(c.getColumnIndex(ColumnName));
					}
				}
			}
			c.close();
		}else {
			result = "nothingToShow";
		}
		db.close();
		return result;
	}
}
