package com.jt.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.book.entity.Book;
import com.jt.book.serviceimpl.BookServiceImpl;

@RestController
@RequestMapping("/api")
public class BookController {
	
	@Autowired
	private BookServiceImpl bookServiceImpl;
	
	@PostMapping("/save")
	public String saveBook(@RequestBody Book book) {
		bookServiceImpl.addBook(book);
		return "Book Add Successfully";
	}
	@PutMapping("/update/{bookId}")
	public String updateBooks(@PathVariable String bookId , @RequestBody Book book) {
		bookServiceImpl.updateBook(bookId, book);
		return "Book Update Successfully";
	}
	@DeleteMapping("/delete/{bookId}")
	public String deleteBooks(@PathVariable String bookId ) {
		bookServiceImpl.deleteBook(bookId);
		return "Delete Successfully";
	}
	@GetMapping("/getid/{bookId}")
	public Book getBookById(@PathVariable String bookId) {
		Book bookById = bookServiceImpl.getBookById(bookId);
		return bookById;
	}
	@GetMapping("/getAll")
	public List<Book> getAllBook(){
		List<Book> allBooks = bookServiceImpl.getAllBooks();
		return allBooks;
	}
}
