package org.example.eshopfinal.entities;

import java.util.Date;

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
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name="id")
    private Long Id;
    private String nom;
    private String prenom;
    private String email;
    private  Integer numtel;
    private Integer codepostal;
    private Date datenais=new Date();
    private Integer cin;
    private boolean flag;
    private String addresse;

    //@OneToMany
    //private List <Commande> commandes;

    @OneToOne
    private User user;


}