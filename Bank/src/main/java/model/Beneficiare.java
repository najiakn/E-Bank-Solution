package model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Beneficiare {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    int id_bene;
    String nom;
    String num_compte_bene ;
    String banque;
}
