package com.jt.book.service;

import java.util.List;

import com.jt.book.entity.Book;

public interface BookService {
	
	public Book addBook(Book book);
	
	public Book updateBook(String bookId , Book book);
	
	public void deleteBook(String bookId);
	
	public Book getBookById(String bookId);
	
	public List<Book> getAllBooks();
}
