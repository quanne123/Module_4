package com.example.bookborrow.Repository;

import com.example.bookborrow.model.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHistoryRepository extends JpaRepository<History, Integer> {
}
