package org.example.bank.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BenificiareDto {
    private  int id_bene;
    private String nom;
    private String num_compte_bene ;
    private  String banque;
}
