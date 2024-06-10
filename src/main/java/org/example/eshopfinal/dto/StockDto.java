package org.example.eshopfinal.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StockDto {

    private Long idstck;
    private Integer qte;
    private String emplacement;
    private boolean flag;

}

