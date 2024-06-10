package org.example.eshopfinal.security;


import lombok.RequiredArgsConstructor;
import org.example.eshopfinal.entities.security.User;
import org.example.eshopfinal.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component

public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(CustomerUserDetailsService.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.debug("Entering in loadUserByUsername Method...");
        Optional<User> byUsername = userRepository.findByUsername(username);
        if (!byUsername.isPresent()) {
            logger.error("Username not found: " + username);
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        logger.info("User Authenticated Successfully: " + username);
        return byUsername.get();
    }
}
