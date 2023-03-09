package com.example.bookborrow.Repository;

import com.example.bookborrow.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository  extends JpaRepository<Book, Integer> {
}
