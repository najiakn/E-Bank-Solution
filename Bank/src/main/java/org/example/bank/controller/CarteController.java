package org.example.bank.controller;

import org.example.bank.model.Carte;
import org.example.bank.service.CarteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Cartes")
public class CarteController {

    @Autowired
    private CarteService carteService;

    @GetMapping
    public List<Carte> getAllCartes() {
        return carteService.getAllCartes();
    }

    @PostMapping("{id_compt}")
    public Carte saveCarte(@RequestBody Carte carte,@PathVariable int id_compt) {
        return carteService.saveCarte(carte, id_compt);
    }


    @DeleteMapping("/{id}")
    public void deleteCarte(@PathVariable int id) {
        carteService.deleteCarte(id);
    }


    @PutMapping("/{id}")
    public Carte updateCarte(@PathVariable int id, @RequestBody Carte carte,@RequestParam  int id_compt ) {
        return carteService.updateCarte(id, carte, id_compt);
    }

}

