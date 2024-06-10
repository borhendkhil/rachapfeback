package org.example.eshopfinal.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name="possede")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "codePossede"
)
public class Possede implements Serializable {

    @EmbeddedId
    private codePossede codePossede;

    @ManyToOne
    @MapsId("idTheme")
    @JoinColumn(name = "idTheme")
    private Theme theme;

    @ManyToOne
    @MapsId("codecar")
    @JoinColumn(name = "codecar")
    private CaracteristiquesProduits caracteristique;

    @ManyToOne
    @MapsId("idPROD")
    @JoinColumn(name = "idPROD")
    private Produit produit;

}
