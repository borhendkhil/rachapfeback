package org.example.eshopfinal.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.eshopfinal.entities.security.Role;


import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRequest {
    private Long id;
    private String username;
    private String password;
    private String mail;
    private String numTel;
    private boolean flag=true;
    private long roleId;
}