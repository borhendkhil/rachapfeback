package org.example.eshopfinal.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RoleDto {
    private String libr;
    private Boolean FLAG;
}
