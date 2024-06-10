package org.example.eshopfinal.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class LivraisonDto {

    private Long idliv;
    private String typeliv;
    private Date dateliv=new Date();
    private Boolean flag;
}