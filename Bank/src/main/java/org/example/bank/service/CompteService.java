package org.example.bank.service;

import org.example.bank.model.Carte;
import org.example.bank.model.Compte;

import java.util.List;

public interface CompteService {
    List<Compte> getAllComptes();
    Compte getCompteById(int id);
    Compte saveCompte(Compte compte);
    void deleteCompte(int id);
    Compte updateCompte(int id);
}
