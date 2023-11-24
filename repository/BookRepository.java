package com.jt.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jt.book.entity.Book;

public interface BookRepository extends JpaRepository<Book, String> {

}
