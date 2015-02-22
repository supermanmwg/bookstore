package com.example.bookstore;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

public class BookDetail extends Activity {
	
	
	private List<BookItem> bookitemList = new ArrayList<BookItem>();
	private int id;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bookdetail);
		Log.d("Activity",getClass().getSimpleName());
		Intent intent = getIntent();
		id = intent.getIntExtra("newid",-1);
		Log.d("BookDetail","book get  id is "+id);
		id=Integer.parseInt(load());
		selectItemDetail(id);
		
		
		BookItem bookItem = bookitemList.remove(0);
		TextView author = (TextView) findViewById(R.id.book_author);
		TextView bookName = (TextView) findViewById(R.id.book_name);
		TextView pages = (TextView) findViewById(R.id.book_pages);
		TextView price = (TextView) findViewById(R.id.book_price);
		

		author.setText("author :" + bookItem.getAuthor());
		
		bookName.setText("book name :"+ bookItem.getBookname());
		
		pages.setText("book pages :"+ Integer.toString(bookItem.getPages()));
		
		price.setText("book price :" + Double.toString(bookItem.getPrice()));
		
		Log.d("MainActivity", "book2 name is " + bookItem.getBookname());
		Log.d("MainActivity", "book2 author is " + bookItem.getAuthor());
		Log.d("MainActivity", "book2 pages is " + bookItem.getPages());
		Log.d("MainActivity", "book2 price is " + bookItem.getPrice());
		

		
	}
	
	private void selectItemDetail( int id) {
		// TODO Auto-generated method stub
		MyDatabaseHelper dbHelper = new MyDatabaseHelper(this, "mwg.db",null,1);
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		
		Cursor cursor = db.rawQuery("select * from Book where id=?",new String[]{Integer.toString(id)});
		Log.d("databaseid","database id is "+Integer.toString(id));
		
		if (cursor.moveToFirst()) {
			do {
				String name = cursor.getString(cursor.getColumnIndex("name"));
				String author = cursor.getString(cursor.getColumnIndex("author"));
				int pages = cursor.getInt(cursor.getColumnIndex("pages"));
				double price = cursor.getDouble(cursor.getColumnIndex("price"));
				
				BookItem  book =new BookItem(id,name,null,author,pages,price);
				bookitemList.add(book);
				Log.d("MainActivity", "book3 name is " + name);
				Log.d("MainActivity", "book3 author is " + author);
				Log.d("MainActivity", "book3 pages is " + pages);
				Log.d("MainActivity", "book3 prices is " + price);
				
			}while(cursor.moveToNext());
			
			cursor.close();
		}	
	}
	
	public String load() {
		FileInputStream in = null;
		BufferedReader reader = null;
		StringBuilder content = new StringBuilder();
		try {
			in = openFileInput("data");
			reader = new BufferedReader(new InputStreamReader(in));
			String line = "";
			while((line = reader.readLine())!=null) {
				content.append(line);
			}	
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(reader != null) {
				try{
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		Log.d("Activity1","load is "+content.toString());
		return content.toString();
	}
}



