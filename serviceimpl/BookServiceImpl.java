package com.jt.book.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.book.entity.Book;
import com.jt.book.exception.ResourceNotFoundException;
import com.jt.book.repository.BookRepository;
import com.jt.book.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book addBook(Book book) {
		Book saveBooks = bookRepository.save(book);
		return saveBooks;
	}

	@Override
	public Book updateBook(String bookId, Book book) {
		Book id = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Not Found"));
		id.setBookPrice(book.getBookPrice());
		Book saveB = bookRepository.save(id);
		
		return saveB;
	}

	@Override
	public void deleteBook(String bookId) {
		
		 	bookRepository.deleteById(bookId);
		 	
		 	Optional.ofNullable(bookRepository.findById(bookId)).orElseThrow(() -> new ResourceNotFoundException("Book Not Found"));
		
	}

	@Override
	public Book getBookById(String bookId) {
		Book id = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book Not Found"));
		
		return id;
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> findAll = bookRepository.findAll();
		return findAll;
	}

}
