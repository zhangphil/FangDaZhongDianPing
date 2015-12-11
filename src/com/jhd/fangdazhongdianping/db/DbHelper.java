package com.jhd.fangdazhongdianping.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper{//初始化一些数据

	private String  user_table="create table  user (id integer primary key	,phone  varchar(11) not null )";
	private String store_table="create table store (id integer primary key ,name text,address text,diqu text," +
			"tel text,info text,shortInfo text,pingjia integer,openTime text,distance integer,price integer," +
			"priceBefore integer,pinglunshu integer,hot integer,hasSold integer,isMianyuyue integet,isCuxiao integer)";
	//初始化一些用户
	private String insert_into_user1="insert into user (phone) values('18333606136');";
	private String insert_into_user2="insert into user (phone) values('110110110');";
	private String insert_into_user3="insert into user (phone) values('admin');";//管理员
	//初始化一些店铺信息
	//private String insert_into_store1="insert into store (name,dis) values();";
	String insert;
	public DbHelper(Context  context) {
		// TODO Auto-generated constructor stub
		this(context, "fangdazhongdianping.db", null, 1);//创建数据库
	}

	public DbHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(user_table);//创建表
	//	db.execSQL(store_table);
		db.execSQL(insert_into_user1);
		db.execSQL(insert_into_user2);
		db.execSQL(insert_into_user3);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
