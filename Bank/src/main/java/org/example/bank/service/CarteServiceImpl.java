package org.example.bank.service;

import org.example.bank.dao.CarteDao;
import org.example.bank.dao.CompteDao;
import org.example.bank.model.Carte;
import org.example.bank.model.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarteServiceImpl implements CarteService {
    @Autowired
    private CarteDao carteDao;

    @Autowired
private CompteDao compteDao;

    @Override
    public List<Carte> getAllCartes() {
        return carteDao.findAll();
    }

    @Override
    public Carte getCarteById(int id) {
        return carteDao.findById(id).orElse(null);
    }

    @Override
    public Carte saveCarte(Carte carte , int id_compte) {
        Compte compte = compteDao.findById(id_compte)
                .orElseThrow(() -> new RuntimeException("Compte introuvable avec l'ID " + id_compte));
        carte.setCompte(compte);
        return carteDao.save(carte);
    }

    @Override
    public void deleteCarte(int id) {
        carteDao.deleteById(id);
    }

    @Override
    public Carte updateCarte(int id, Carte carte, int id_compt) {
        Optional<Carte> existCarte = carteDao.findById(id);
        if (existCarte.isPresent()) {
            Carte existingCarte = existCarte.get();
            existingCarte.setDate_expiration(carte.getDate_expiration());
            existingCarte.setNum_carte(carte.getNum_carte());
            existingCarte.setType_carte(carte.getType_carte());
            Compte compte= compteDao.findById(id_compt).orElseThrow(() ->
                    new RuntimeException("Compte introuvable avec l'ID " + id_compt));

            existingCarte.setCompte(compte);
            return carteDao.save(existingCarte);
        } else {
            return null;
        }
    }

    private static Carte getCarte(Optional<Carte> existingCarte) {
        Carte updateCarte = existingCarte.get();
        return updateCarte;
    }

}
