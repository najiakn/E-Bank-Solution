package model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id_trans;
    Date date_trans;
    float montant;
    String type_transact;
    String description;
    @ManyToOne
    @JoinColumn(name = "id_compt")
    private Compte compte;

    @ManyToOne
    @JoinColumn(name = "id_bene")
    private Beneficiare beneficiare;
}
