package org.example.eshopfinal.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String libm;
    private String description;
    private boolean flag;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;

    @OneToMany
    @JoinColumn(name="idm")
    private List <Produit> p;


}

