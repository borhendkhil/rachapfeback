package org.example.eshopfinal.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ThemeDto {

    private Long idTheme;
    private String libtheme;
    private boolean flag;
}
