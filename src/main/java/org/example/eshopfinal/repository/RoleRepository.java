package org.example.eshopfinal.repository;

import org.example.eshopfinal.entities.security.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository  extends CrudRepository<Role, Long>{
    Optional<Role> findByLabel(String label);
}
