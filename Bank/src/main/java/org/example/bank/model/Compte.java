package org.example.bank.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id_compt;
    private  String type_compte;
    private  float sold_initial;
    private  Date date_creation;

}
