package org.example.eshopfinal.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CouleurDto {

    private Long id;
    private String codecl;
    private String libcl;
    private boolean flag;
}