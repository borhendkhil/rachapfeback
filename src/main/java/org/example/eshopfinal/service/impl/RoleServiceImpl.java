package org.example.eshopfinal.service.impl;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.example.eshopfinal.entities.security.Role;
import jakarta.transaction.Transactional;
import org.example.eshopfinal.service.IRoleService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.web.server.ResponseStatusException;
import org.example.eshopfinal.repository.RoleRepository;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService {
    private final RoleRepository roleRepository;
    @Override
    public Role ajouterRrole(Role r) {
        roleRepository.save(r);
        return r;
    }

    @Transactional
    @Override
    public void updaterole(Role r, long idr) {
        Role roleToUpdate = roleRepository.findById(idr).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"role existe pas dans la base de données")
        );
        if(r.getLabel()!= null && !r.getLabel().isEmpty()){
            roleToUpdate.setLabel(r.getLabel());

        }

    }

    @Transactional
    @Override
    public Role FlagRole(Long idr) {
        Role role = roleRepository.findById(idr).orElseThrow(() -> new UsernameNotFoundException("Role not found"));
        role.setFlag(!role.getFlag());
        return roleRepository.save(role);
    }


    @Override
    public List<Role> getAllRole() {
        return (List<Role>) roleRepository.findAll();
    }


    @Override
    public Role getRoleById(Long idr) {
        return roleRepository.findById(idr).orElse(null);
    }

    public boolean isRoleActive(String roleName) {
        Optional<Role> roleOptional = roleRepository.findByLabel(roleName);
        return roleOptional.map(Role::getFlag).orElse(false);
    }
}

