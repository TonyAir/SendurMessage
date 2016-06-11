package com.zzm.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper{
	
	public DBOpenHelper(Context context, String name) {
		super(context, name, null, 1);
		// TODO Auto-generated constructor stub
	}
	public DBOpenHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override//�״δ������ݿ��ʱ����� һ����԰ѽ��� ����Ĳ���
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table if not exists talktb(_id integer primary key autoincrement,keyword text not null,detail text not null)");
		db.execSQL("insert into talktb(keyword,detail)values('hello','hello your family')");
	}

	@Override//�����ݿ�İ汾�����仯��ʱ�� ���Զ�ִ��
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
