package org.example.bank.dao;

import org.example.bank.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteDao extends JpaRepository<Compte, Integer> {
}
