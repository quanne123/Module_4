package com.example.bookborrow.service;

import com.example.bookborrow.exception.InvalidCodeException;
import com.example.bookborrow.exception.OutOfBookException;
import com.example.bookborrow.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> showList();

    Integer borrowBooks(int id) throws OutOfBookException;

    boolean returnBooks(int code) throws InvalidCodeException;
}
