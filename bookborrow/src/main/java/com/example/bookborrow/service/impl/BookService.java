package com.example.bookborrow.service.impl;

import com.example.bookborrow.Repository.IBookRepository;
import com.example.bookborrow.exception.InvalidCodeException;
import com.example.bookborrow.exception.OutOfBookException;
import com.example.bookborrow.model.Book;
import com.example.bookborrow.model.History;
import com.example.bookborrow.service.IBookService;
import com.example.bookborrow.service.IHistoryService;
import org.hibernate.dialect.lock.OptimisticEntityLockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional(rollbackOn = Throwable.class)
@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private IHistoryService historyService;

    @Override
    public List<Book> showList() {
        return bookRepository.findAll();
    }

    @Override
    public Integer borrowBooks(int id) throws OutOfBookException {
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null) {
            return -1;
        }
        if (book.getAmount() == 0) {
            throw new OutOfBookException("");
        }
        book.setAmount(book.getAmount() - 1);
        int code = (int) Math.floor(((Math.random()) * 89999) + 10000);
        History history = new History();
        history.setBookId(book.getId());
        history.setCode(code);
        historyService.addHistory(history);
        try {
            bookRepository.save(book);
        } catch (IllegalArgumentException | OptimisticEntityLockException e) {
            return null;
        }
        return code;
    }

    @Override
    public boolean returnBooks(int code) throws InvalidCodeException {
        Optional<History> history = historyService.getBooksByCode(code);
        if (history.isPresent()) {
            int bookId = history.get().getBookId();
            Book book = bookRepository.findById(bookId).get();
            book.setAmount(book.getAmount() + 1);
            try {
                bookRepository.save(book);
            } catch (IllegalArgumentException | OptimisticEntityLockException e){
                return false;
            }
            historyService.deleteHistory(code);
            return true;
        } else {
            throw new InvalidCodeException("Code không hợp lệ");
        }
    }
}