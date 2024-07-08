package org.example.bank.service;

import org.example.bank.model.Carte;

import java.util.List;

public interface CarteService {
    List<Carte> getAllCartes();
    Carte getCarteById(int id);
    Carte saveCarte(Carte carte);
    void deleteCarte(int id);
    Carte updateCarte(int id, Carte carte);

}
