

package com.sis.broadcaset;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
/**
 *  �����û���ϣ�����չʾBroadcast ��ʾ�����롣
 * @author Administrator
 *
 */
public class SendBroadCastListener implements OnClickListener {

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		intent.putExtra("data", "broadcast");
		//intent.setAction(action);
		//sendBroadcast(intent);
	}

}
