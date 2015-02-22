package com.example.bookstore;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class BookItemAdapter extends ArrayAdapter<BookItem> {

	private int resourceId;
	
	public BookItemAdapter(Context context, int resource, List<BookItem> objects) {
		super(context, resource, objects);
		resourceId = resource;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		BookItem book = getItem(position);
		Log.d("position","position"+position);
		View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
		TextView bookName = (TextView)view.findViewById(R.id.book_name);
		TextView bookAuthor = (TextView)view.findViewById(R.id.book_author);
		TextView bookPages = (TextView)view.findViewById(R.id.book_pages);
		TextView bookPrice = (TextView)view.findViewById(R.id.book_price);
		
		bookName.setText("<<"+book.getBookname()+">>"+"  "+book.getAuthor());
		bookAuthor.setText(book.getAuthor());
		bookPages.setText(book.getPages());
		bookPrice.setText(Double.toString(book.getPrice()));
		return view;
	}

}
