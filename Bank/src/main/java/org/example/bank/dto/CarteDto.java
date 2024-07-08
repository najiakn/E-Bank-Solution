package org.example.bank.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.bank.model.Compte;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarteDto {

    private  int id_carte;
    private   String num_carte;
    private   Date date_expiration;
    private  String type_carte;
     @ManyToOne
     @JoinColumn(name = "id_compt")
     private Compte compte;
}
