package org.example.eshopfinal.repository;

import org.example.eshopfinal.entities.security.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends RefreshableCRUDRepository<User, Long> {

    Optional<User> findByUsername(String username);
    User findFirstById(Long id);

//    UserInfo findByRole(Role role);
}
