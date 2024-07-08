package org.example.bank.dao;

import org.example.bank.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurDao extends JpaRepository<Utilisateur, Integer> {
}
