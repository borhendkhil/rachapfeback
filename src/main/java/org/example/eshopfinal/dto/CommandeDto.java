package org.example.eshopfinal.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Builder
@Data
public class CommandeDto {

    private Integer numtransac;
    private Date datecmd;
    private String etatcmd;
    private String piece;
    private Integer nbarticle;
    private float totalcmd;
    private boolean flag;
}