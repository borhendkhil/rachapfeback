package org.example.eshopfinal.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MarqueDto {

    private Long idm;
    private String libm;
    private String description;
    private boolean flag;
}
