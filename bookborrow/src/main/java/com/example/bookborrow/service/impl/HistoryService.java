package com.example.bookborrow.service.impl;

import com.example.bookborrow.Repository.IHistoryRepository;
import com.example.bookborrow.model.History;
import com.example.bookborrow.service.IHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HistoryService implements IHistoryService {
    @Autowired
    private IHistoryRepository historyRepository;

    @Override
    public Optional<History> getBooksByCode(int code) {
        Optional<History> history = historyRepository.findById(code);
        return history;
    }

    @Override
    public boolean deleteHistory(int code) {
        try {
            historyRepository.deleteById(code);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean addHistory(History history) {
        try {
            historyRepository.save(history);
        } catch (IllegalArgumentException e){
            return  false;
        }
        return true;
    }
}
