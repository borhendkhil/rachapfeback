package org.example.eshopfinal.entities;

import java.util.Date;
import java.util.List;

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
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long idcmd;
    private Integer numtransac;
    private Date datecmd;
    private String etatcmd;
    private Integer nbarticle;
    private float totalcmd;
    private boolean flag;




    @ManyToOne
    private Client client;

    //@OneToOne
    //private Livraison livraison;

    //@ManyToMany
    //private List<Produit> produits;
}