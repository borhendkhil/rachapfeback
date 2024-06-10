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
public class Couleur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String codecl;
    private String libcl;
    private boolean flag;



    @OneToMany
    @JoinColumn(name="idc")
    private List<Stock> stocks;
}

