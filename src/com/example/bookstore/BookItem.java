package com.example.bookstore;

public class BookItem {
	private String bookname;
	private String databasename;
	private String author;
	private int pages;
	private double price;
	private int id;

	public BookItem(int id,String bookname,String databasename,String author, int pages,double price){
		this.id = id;
		this.author = author;
		this.bookname = bookname;
		this.pages = pages;
		this.price = price;
		this.databasename = databasename;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getBookname() {
		return bookname;	
	}
	
	public String getDatabasename() {
		return databasename;	
	}
	
	public int getPages() {
		return pages;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getId() {
		return id;
	}
}
