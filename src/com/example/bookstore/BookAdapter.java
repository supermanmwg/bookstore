package com.example.bookstore;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class BookAdapter extends ArrayAdapter<BookItem> {

	private int resourceId;
	private Context viewContext;
	private int id;
	
	public BookAdapter(Context context, int resource, List<BookItem> objects) {
		super(context, resource, objects);
		resourceId = resource;
		viewContext = context;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		BookItem book = getItem(position);
		View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
		
		id = book.getId();
		TextView bookitemName = (TextView)view.findViewById(R.id.book_item);
		bookitemName.setText("<<"+book.getBookname()+">>"+"  "+book.getAuthor());
	
		return view;
	}

}
