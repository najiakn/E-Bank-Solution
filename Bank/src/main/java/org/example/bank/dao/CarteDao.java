package org.example.bank.dao;

import org.example.bank.model.Carte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteDao extends JpaRepository<Carte, Integer> {
}
