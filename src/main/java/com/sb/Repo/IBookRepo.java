package com.sb.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.beans.Book;

@Repository
public interface IBookRepo extends JpaRepository<Book, Long> {

}
