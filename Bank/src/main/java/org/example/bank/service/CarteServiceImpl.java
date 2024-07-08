package org.example.bank.service;

import org.example.bank.dao.CarteDao;
import org.example.bank.model.Carte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarteServiceImpl implements CarteService {
    @Autowired
    private CarteDao carteDao;


    @Override
    public List<Carte> getAllCartes() {
        return carteDao.findAll();
    }

    @Override
    public Carte getCarteById(int id) {
        return carteDao.findById(id).orElse(null);
    }

    @Override
    public Carte saveCarte(Carte movie) {
        return carteDao.save(movie);
    }

    @Override
    public void deleteCarte(int id) {
        carteDao.deleteById(id);
    }

    @Override
    public Carte updateCarte(int id, Carte movie) {
        Optional<Carte> existCarte = carteDao.findById(id);
        if (existCarte.isPresent()) {
            Carte updateCatre = getCarte(existCarte);
            updateCatre.setCompte(movie.getCompte());
            updateCatre.setNum_carte(movie.getNum_carte());
            updateCatre.setType_carte(movie.getType_carte());
            updateCatre.setDate_expiration(movie.getDate_expiration());
            return carteDao.save(updateCatre);
        } else {
            return null;
        }
    }

    private static Carte getCarte(Optional<Carte> existingMovie) {
        Carte updatedMovie = existingMovie.get();
        return updatedMovie;
    }

}
