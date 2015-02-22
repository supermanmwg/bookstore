package com.example.bookstore;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class QueryBook extends Activity {
	
	private List<BookItem> bookList = new ArrayList<BookItem>();
	private Bundle saved;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		saved = savedInstanceState;
		setContentView(R.layout.querybook);
		Log.d("Activity1","haha"+getClass().getSimpleName());
		queryBook();
		BookAdapter adapter = new BookAdapter(QueryBook.this, R.layout.bookitem, bookList);
		ListView listView = (ListView) findViewById(R.id.list_view);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Log.d("Activity1",getClass().getSimpleName());
				// TODO Auto-generated method stub
				BookItem bookItem = bookList.get(position);
	
				id = bookItem.getId();
				int shortId = (int) id;
				Log.d("QueryBook","id number is " +shortId);
				save(String.valueOf(id));
				Intent intent = new Intent(QueryBook.this, BookDetail.class);
				intent.putExtra("newid",shortId);
				startActivity(intent);
		
			}
		});

	}
	
	private void save(String id) {
		FileOutputStream out = null;
		BufferedWriter writer = null;
		try {
			out = openFileOutput("data",Context.MODE_PRIVATE);
			writer = new BufferedWriter(new OutputStreamWriter(out));
			writer.write(id);
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			try{
				if(writer !=null) {
					writer.close();
				}
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private void queryBook() {
		MyDatabaseHelper dbHelper = new MyDatabaseHelper(this, "mwg.db",null,1);
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		Cursor cursor = db.query("Book", null, null, null, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				int id = cursor.getInt(cursor.getColumnIndex("id"));
				String name = cursor.getString(cursor.getColumnIndex("name"));
				String author = cursor.getString(cursor.getColumnIndex("author"));
				int pages = cursor.getInt(cursor.getColumnIndex("pages"));
				double price = cursor.getDouble(cursor.getColumnIndex("price"));
				
				BookItem  book =new BookItem(id,name,null,author,pages,price);
				bookList.add(book);
				Log.d("MainActivity","book id is " +id);
				Log.d("MainActivity", "book name is " + name);
				Log.d("MainActivity", "book author is " + author);
				Log.d("MainActivity", "book pages is " + pages);
				Log.d("MainActivity", "book prices is " + price);
				
			}while(cursor.moveToNext());
			
			cursor.close();
		}
		
		
	}

}
