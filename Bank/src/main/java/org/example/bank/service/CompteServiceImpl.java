package org.example.bank.service;

import org.example.bank.dao.CompteDao;
import org.example.bank.model.Carte;
import org.example.bank.model.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteServiceImpl  implements CompteService {

    @Autowired
    private CompteDao compteDao;
    @Override
    public List<Compte> getAllComptes() {
        return compteDao.findAll();
    }

    @Override
    public Compte getCompteById(int id) {
        return compteDao.findById(id).orElse(null);

    }

    @Override
    public Compte saveCompte(Compte compte) {
        return null;
    }

    @Override
    public void deleteCompte(int id) {

    }

    @Override
    public Compte updateCompte(int id) {
        return null;
    }
}
