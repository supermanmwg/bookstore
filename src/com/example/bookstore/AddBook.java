package com.example.bookstore;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class AddBook extends Activity   implements OnClickListener {
	
	private EditText[] editText;
	Button addbook;
	
	@Override 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addbook);
		addbook = (Button) findViewById(R.id.sure1);
		editText = new EditText[6];
		
		editText[0] = (EditText) findViewById(R.id.database1);
		editText[1] = (EditText) findViewById(R.id.bookname1);
		editText[2] = (EditText) findViewById(R.id.author1);
		editText[3] = (EditText) findViewById(R.id.pages1);
		editText[4] = (EditText) findViewById(R.id.price1);
		

		addbook.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		
		// TODO Auto-generated method stub
		addBook(editText);
	
		switch (v.getId()) {
		case R.id.sure1:
			Intent intent = new Intent(AddBook.this, MainActivity.class);
			startActivity(intent);
		}
		
	}
	
	private void addBook(EditText[] editText) {
		

		
		String databasename = editText[0].getText().toString();
		String bookname = editText[1].getText().toString();
		String author = editText[2].getText().toString();
		int pages = Integer.parseInt(editText[3].getText().toString());
		double price = Double.parseDouble(editText[4].getText().toString());
		Log.d("MainActivity", "book name is " + bookname);
		Log.d("MainActivity", "book author is " + author);
		Log.d("MainActivity", "book pages is " + pages);
		Log.d("MainActivity", "book prices is " + price);
		MyDatabaseHelper dbHelper = new MyDatabaseHelper(this, databasename+".db",null,1);
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("name", bookname);
		values.put("author",author);
		values.put("pages", pages);
		values.put("price", price);
		db.insert("Book",null,values);	
		values.clear();
	}
		
}
