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
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String libcateg;
    private  boolean flag;

    @OneToMany
    @JoinColumn(name="id")
    private List<Produit> produitList;
}
