package org.example.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompteDto {

    private int id_compt;
    private  String type_compte;
    private  float sold_initial;
    private Date date_creation;
}
