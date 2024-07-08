package org.example.bank.model;
import jakarta.persistence.*;
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

public class Carte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id_carte;
    private String num_carte;
    private Date date_expiration;
    private String type_carte;
     @ManyToOne
    @JoinColumn(name = "id_compt")
    private Compte compte;
}
