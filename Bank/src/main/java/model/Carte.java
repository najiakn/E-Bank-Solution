package model;
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
    int id_carte;
    String num_carte;
    Date date_expiration;
    String type_carte;
    @ManyToOne
    @JoinColumn(name = "id_compt")
    private Compte compte;
}
