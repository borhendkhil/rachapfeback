package org.example.eshopfinal.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailCarecteristique {
    @Id
    private Long idvaleur;
    private String valeur;

    @OneToOne
    private CaracteristiquesProduits caracteristiquesProduits;

}
