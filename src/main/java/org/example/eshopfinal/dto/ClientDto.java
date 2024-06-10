package org.example.eshopfinal.dto;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Builder
@Data
public class ClientDto {
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
}
