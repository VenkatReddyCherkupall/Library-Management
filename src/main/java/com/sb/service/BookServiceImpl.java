package com.sb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.Repo.IBookRepo;
import com.sb.Repo.IUserRepo;
import com.sb.beans.Book;
import com.sb.beans.User;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private IBookRepo bookRepo;
	
	@Autowired
	private IUserRepo userRepo;
	
	
	@Override
	public Book addBook(Book book) {
		
		return bookRepo.save(book) ;
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}

	@Override
	public Book getBook(Long id) {
		return bookRepo.findById(id).orElse(null);
	}

	@Override
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}

	@Override
	public Book borrowBook(Long userid, Long bookid) {
		Book book = bookRepo.findById(bookid).orElseThrow(null);
		User user = userRepo.findById(userid).orElseThrow(null);
		
		if(book != null && user != null && !book.isBorrowed()) {
			book.setBorrowed(true);
			book.setBorrowedBy(user);
			return bookRepo.save(book);
		}else {
		return null;
		}
	}

	@Override
	public Book returnBook(Long bookid) {
		Book book = bookRepo.findById(bookid).orElseThrow(null);
		if(book != null && book.isBorrowed() ) {
			book.setBorrowed(false);
			book.setBorrowedBy(null);
			return bookRepo.save(book);
		}
		return null;
	}



}
