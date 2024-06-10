package org.example.eshopfinal.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.eshopfinal.entities.security.User;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long idPROD ;
    private String nomprod;
    private Integer reference;
    private float prix;
    private Date date =new Date();
    private String description;
    private Boolean flag;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;

    @ManyToOne
    @JoinColumn(name="idm")
    private Marque m;

    @OneToMany
    private List<Stock> stock;

    @ManyToOne
    @JoinColumn(name="id")
    private Categorie categorie;


    @ManyToMany
    private  List<User> userEntityList;

    @ManyToMany
    private List<Commande> commandes;





}

