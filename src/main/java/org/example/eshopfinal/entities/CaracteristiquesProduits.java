package org.example.eshopfinal.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class CaracteristiquesProduits {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codecar;
    private String libcar;
    private boolean flag;

    @OneToOne
    private Theme theme;

    @OneToMany
    private List<DetailCarecteristique> detaliCarecterstiqueList;


}
