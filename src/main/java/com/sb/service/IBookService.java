package com.sb.service;


import java.util.List;

import com.sb.beans.Book;
import com.sb.beans.User;

public interface IBookService {

	public Book addBook(Book book);
	public List<Book> getAllBooks();
	public Book getBook(Long id);
	public void deleteBook(Long id);
	public Book borrowBook(Long userid, Long bookid);
	public Book returnBook(Long bookid);
}
