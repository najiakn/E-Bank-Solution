package org.example.bank.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class TransactionDto {
    private int id_trans;
    private Date date_trans;
    private float montant;
    private String type_transact;
    private String description;
    @ManyToOne
    @JoinColumn(name = "id_compt")
    private Compte compte;
}
