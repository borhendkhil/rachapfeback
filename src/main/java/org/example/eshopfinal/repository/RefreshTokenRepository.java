package org.example.eshopfinal.repository;


import org.example.eshopfinal.entities.security.User;
import org.example.eshopfinal.models.RefreshToken;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author mhmdz
 * Created By Zeeshan on 20-05-2023
 * @project oauth-jwt
 */
@Repository
public interface RefreshTokenRepository extends RefreshableCRUDRepository<RefreshToken, Integer> {

    Optional<RefreshToken> findByToken(String token);

    Optional<RefreshToken> findByUser(User user);
}