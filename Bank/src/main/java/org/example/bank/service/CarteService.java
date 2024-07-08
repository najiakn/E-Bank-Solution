package org.example.bank.service;

import org.example.bank.model.Carte;

import java.util.List;

public interface CarteService {
    List<Carte> getAllCartes();
    Carte getCarteById(int id);
    Carte saveCarte(Carte carte, int id_compte);
    void deleteCarte(int id);
    Carte updateCarte(int id, Carte carte , int id_compt);

}
