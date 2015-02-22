package com.example.bookstore;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateBookdatabase extends Activity  implements OnClickListener{

	private EditText editText;
	Button addDatabase;
	@Override 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.createdatabase);
		Intent intent = getIntent();
		String data = intent.getStringExtra("haha");
		Log.d("haha","the string is "+ data);
		addDatabase = (Button) findViewById(R.id.sure);
		editText = (EditText) findViewById(R.id.edit_text);
		addDatabase.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.sure:
			String inputText = editText.getText().toString();
			MyDatabaseHelper dbHelper = new MyDatabaseHelper(this, inputText+".db",null,1);
			dbHelper.getReadableDatabase();
			Log.d("database","database name is " + inputText);
			Toast.makeText(CreateBookdatabase.this, "创建数据库"+inputText+"成功", Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(CreateBookdatabase.this, MainActivity.class);
			startActivity(intent);	
		}
		
	}
	
}
/*
public class CreateBookdatabase extends Activity implements OnClickListener {
	
	private EditText editText;
	@Override 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.createdatabase);
		Button addDatabase = (Button) findViewById(R.id.create_bookdatabase);
		editText = (EditText) findViewById(R.id.edit_text);
		addDatabase.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.create_bookdatabase:
			String inputText = editText.getText().toString();
			MyDatabaseHelper dhHelper = new MyDatabaseHelper(this, inputText,null,1);
			
		}
	}
}
*/