package com.example.bookborrow.service;

import com.example.bookborrow.model.History;

import java.util.Optional;

public interface IHistoryService {
    Optional<History> getBooksByCode(int code);

    boolean deleteHistory(int code);

    boolean addHistory(History history);
}