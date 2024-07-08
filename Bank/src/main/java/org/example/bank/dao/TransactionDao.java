package org.example.bank.dao;

import org.example.bank.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDao extends JpaRepository<Transaction, Integer> {
}
