package org.example.eshopfinal.security;

import org.example.eshopfinal.entities.security.Role;
import org.example.eshopfinal.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Autowired
    private RoleRepository roleRepository;

    @Bean
    public ApplicationRunner initializer() {
        return args -> {
            initializeRoles();
        };
    }

    private void initializeRoles() {
        createRoleIfNotFound("ADMIN");
        createRoleIfNotFound("LOGISTIQUE");
        createRoleIfNotFound("VENDEUR");
    }

    private void createRoleIfNotFound(String roleName) {
        Role roleByName=roleRepository.findByLabel(roleName).orElse(null);
        if (roleByName == null) {
            Role role = new Role();
            role.setLabel(roleName);
            role.setFlag(true);
            roleRepository.save(role);
        }
    }
}
