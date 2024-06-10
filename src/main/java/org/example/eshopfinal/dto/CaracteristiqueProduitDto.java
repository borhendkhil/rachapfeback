package org.example.eshopfinal.dto;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class CaracteristiqueProduitDto {

    private Long codecar;
    private String libcar;
    private boolean flag;
}