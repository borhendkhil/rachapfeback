package org.example.eshopfinal.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class ProduitDto {


    private Long idprod;
    private String nomprod;
    private Integer reference;
    private float prix;
    private Date date =new Date();
    private String description;
    private Boolean flag;
}

