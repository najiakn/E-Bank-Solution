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

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_trans;
    private Date date_trans;
    private float montant;
    private String type_transact;
    private String description;
    @ManyToOne
    @JoinColumn(name = "id_compt")
    private Compte compte;

    @ManyToOne
    @JoinColumn(name = "id_bene")
    private Beneficiare beneficiare;
}
