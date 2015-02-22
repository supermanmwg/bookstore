package com.example.bookstore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	@Override 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Button createDatabase = (Button) findViewById(R.id.create_bookdatabase);
		createDatabase.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent("com.example.bookstore.createbookdatabase");
				intent.putExtra("haha", "haha");
				startActivity(intent);
				
			}
			
		});
		

		Button addBook = (Button) findViewById(R.id.addbook);
		addBook.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub	
				Intent intent = new Intent("com.example.bookstore.addbook");
				startActivity(intent);
			}
			
		});
		

		Button queryBook = (Button) findViewById(R.id.query_book);
		queryBook.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent("com.example.bookstore.querybook");
				startActivity(intent);
			}
			
		});
		

		Button queryDatabase = (Button) findViewById(R.id.query_database);
		queryDatabase.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	

}
