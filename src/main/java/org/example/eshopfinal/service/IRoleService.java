package org.example.eshopfinal.service;

import org.example.eshopfinal.entities.security.Role;

import java.util.List;


public interface IRoleService {
    Role ajouterRrole(Role r);
    void updaterole( Role r , long idr);
    Role FlagRole(Long idr);
    List <Role> getAllRole();
    Role getRoleById(Long idr);
    public boolean isRoleActive(String roleName);

}
