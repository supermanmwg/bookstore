package com.example.bookstore;

import android.content.Context;
import android.database.sqlite.*;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;
import android.widget.Toast;


public class MyDatabaseHelper extends SQLiteOpenHelper {
	
	public static final String CREATE_BOOK = "create table Book ("
			+ "id integer primary key autoincrement,"
			+ "author text,"
			+ "price real,"
			+ "pages integer,"
			+ "name text,"
			+ "category_id integer)";
	
	public static final String CREATE_CATEGORY = "create table Category ("
			+ "id integer primary key autoincrement,"
			+ "category_name text,"
			+ "category_code integer)";
	
	private Context mContext;
	
	public MyDatabaseHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name , factory, version);
		mContext = context;
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_BOOK);
		db.execSQL(CREATE_CATEGORY);
		Log.d("database","Create db and tables");
	}
	
	@Override 
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		/*
		switch (oldVersion) {
		case 1:
			db.execSQL("drop table if exists Book");
			db.execSQL("drop table if exists Category");
			onCreate(db);
		case 2:
		//	db.execSQL("alter table Book add column category_id integer");
		default:
		}
		*/
	}
	

}
