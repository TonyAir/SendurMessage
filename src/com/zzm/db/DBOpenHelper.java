package com.zzm.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {

	public DBOpenHelper(Context context, String name) {
		super(context, name, null, 1);
		// TODO Auto-generated constructor stub
	}

	public DBOpenHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	// �״δ������ݿ��ʱ����� һ����԰ѽ��� ����Ĳ���
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		// Create the talktb table for Talk's content
		db.execSQL("create table if not exists talktb(_id integer primary key autoincrement,keyword text not null,detail text not null)");
		db.execSQL("insert into talktb(keyword,detail)values('hello','hello your family')");
		// Create the usertb table for User's information
		db.execSQL("create table if not exists usertb(_id integer primary key autoincrement,username text not null,password text not null,permissions text not null,loaded text not null)");
		db.execSQL("insert into usertb(username,password,permissions,loaded)values('zzm','zzm111','0','1')");
	}

	@Override
	// �����ݿ�İ汾�����仯��ʱ�� ���Զ�ִ��
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
