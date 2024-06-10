package org.example.eshopfinal.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table

public class Stock {
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idstck;
    private Integer qte;
    private String emplacement;
    private boolean flag;

    @ManyToOne
    @JoinColumn(name="idprod")
    private Produit produit;

    @ManyToOne
    @JoinColumn(name="idc")
    private Couleur couleur;



}