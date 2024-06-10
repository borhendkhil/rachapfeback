package org.example.eshopfinal.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table
@Builder

public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTheme;
    private String libtheme;
    private boolean flag;

    @OneToMany
    private List<CaracteristiquesProduits> caracteristiquesProduitsList;


}
