package com.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.beans.Book;
import com.sb.service.BookServiceImpl;

@RestController
@RequestMapping("/api/book")
public class BookController {

	@Autowired
	private BookServiceImpl bookServiceImpl;

	@PostMapping
	public Book addBook(@RequestBody Book book) {
		return bookServiceImpl.addBook(book);
	}

	@GetMapping
	public List<Book> getAllBooks() {
		return bookServiceImpl.getAllBooks();
	}

	@GetMapping("/{id}")
	public Book getBook(@PathVariable Long id) {
		return bookServiceImpl.getBook(id);
	}

	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable Long id) {
		 bookServiceImpl.deleteBook(id);
	}
	
	@PostMapping("/{bookid}/user/{userid}")
	public Book borrowBook(@PathVariable Long bookid, @PathVariable Long userid) {
		Book book = bookServiceImpl.borrowBook(userid, bookid);
		if(book != null) {
			return book;
		}else {
			return null;
		}
	}
	
	@PostMapping("/{bookid}/return")
	public Book returnBook(@PathVariable Long bookid) {
		Book book = bookServiceImpl.returnBook(bookid);
		if(book != null ) {
			return book;
		}
		return null;
	}

}
