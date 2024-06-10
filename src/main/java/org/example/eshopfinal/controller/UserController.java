package org.example.eshopfinal.controller;


import org.example.eshopfinal.decorators.ActiveRole;
import org.example.eshopfinal.dto.*;
import org.example.eshopfinal.entities.security.User;
import org.example.eshopfinal.models.RefreshToken;
import org.example.eshopfinal.repository.UserRepository;
import org.example.eshopfinal.security.JwtUtilities;
import org.example.eshopfinal.service.impl.RefreshTokenService;
import org.example.eshopfinal.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.security.auth.login.AccountNotFoundException;
import javax.security.auth.login.CredentialException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*")
public class UserController {
    //ADmin
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final IUserService userService;
    private final JwtUtilities jwtUtilities;
    private final RefreshTokenService refreshTokenService;
    private  final AuthenticationManager authenticationManager;
    @Autowired
    private  UserRepository userRepository;


    public UserController(IUserService userService, JwtUtilities jwtUtilities, RefreshTokenService refreshTokenService, AuthenticationManager authenticationManager){
        this.userService=userService;
        this.jwtUtilities = jwtUtilities;
        this.refreshTokenService=refreshTokenService;
        this.authenticationManager=authenticationManager;
        this.userRepository = userRepository;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> saveUser(@RequestBody UserRequest userRequest) {
        try {
            UserResponse userResponse = userService.saveUser(userRequest);
            return ResponseEntity.ok(userResponse);
        } catch (Exception e) {
            logger.error("Error saving user: {}", e.getMessage());
            return ResponseEntity.internalServerError().body(new Error("Error saving user: " + e.getMessage()));
        }
    }

    @PostMapping("/login")
    public JwtResponseDTO authenticateAndGetToken(@RequestBody AuthRequestDTO authRequestDTO) throws AccountNotFoundException, CredentialException {
        try {
            System.out.println("Authenticating user...");
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            Optional<User> user = userRepository.findByUsername(authentication.getName());
            System.out.println("User found: " + user);
            if (user.isPresent()) {
                if (authentication.isAuthenticated()) {
                    List<String> rolesNames = new ArrayList<>();
                    User connectedUser = user.get();
                    rolesNames.add(connectedUser.getRoles().getLabel());
                    RefreshToken refreshToken = refreshTokenService.createRefreshToken(authRequestDTO.getUsername());
                    return JwtResponseDTO.builder()
                            .accessToken(jwtUtilities.generateToken(connectedUser.getUsername(), rolesNames))
                            .token(refreshToken.getToken())
                            .build();
                }
                throw new CredentialException("Wrong credentials");
            }
            throw new UsernameNotFoundException("User not found");
        } catch (Exception e) {
            e.printStackTrace();
            throw new CredentialException("Authentication failed");
        }
    }


//    @PostMapping("/login")
//    public ResponseEntity<JwtResponseDTO> authenticateAndGetToken(@RequestBody AuthRequestDTO authRequestDTO) {
//        try {
//            logger.debug("Authenticating user: {}", authRequestDTO.getUsername());
//
//            // Attempt to authenticate the user
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword())
//            );
//
//            // Set the authentication context
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//
//            // Find the user by username
//            Optional<User> userOptional = userRepository.findByUsername(authentication.getName());
//
//            // Check if the user exists
//            if (userOptional.isPresent()) {
//                User user = userOptional.get();
//
//                // Check if the authentication was successful
//                if (authentication.isAuthenticated()) {
//                    List<String> rolesNames = Collections.singletonList(user.getRoles().getLabel());
//
//                    // Create a refresh token
//                    RefreshToken refreshToken = refreshTokenService.createRefreshToken(authRequestDTO.getUsername());
//
//                    // Generate the JWT response
//                    JwtResponseDTO responseDTO = JwtResponseDTO.builder()
//                            .accessToken(jwtUtilities.generateToken(user.getUsername(), rolesNames))
//                            .token(refreshToken.getToken())
//                            .build();
//
//                    logger.debug("User authenticated successfully: {}", authRequestDTO.getUsername());
//                    return ResponseEntity.ok(responseDTO);
//                } else {
//                    logger.error("Authentication failed for user: {}", authRequestDTO.getUsername());
//                    throw new BadCredentialsException("Authentication failed");
//                }
//            } else {
//                logger.error("User not found: {}", authRequestDTO.getUsername());
//                throw new UsernameNotFoundException("User not found");
//            }
//        } catch (BadCredentialsException ex) {
//            logger.error("Bad credentials for user: {}", authRequestDTO.getUsername(), ex);
//            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid username or password");
//        } catch (UsernameNotFoundException ex) {
//            logger.error("User not found: {}", authRequestDTO.getUsername(), ex);
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
//        } catch (Exception ex) {
//            logger.error("Authentication process failed", ex);
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Authentication process failed");
//        }
//    }




    @GetMapping("/users")
    @ActiveRole(roles = {"ADMIN"})
    public ResponseEntity<?> getAllUsers() {
        try {
            List<UserResponse> userList = userService.getAllUser();
            return ResponseEntity.ok(userList);
        } catch (Exception e){
           return ResponseEntity.internalServerError().body("Users list can't be retrieved");
        }
    }

    @PostMapping("/profile")
    public ResponseEntity<UserResponse> getUserProfile() {
        try {
            UserResponse userResponse = userService.getCurrentUser();
            return ResponseEntity.ok().body(userResponse);
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PostMapping("/refreshToken")
    public JwtResponseDTO refreshToken(@RequestBody RefreshTokenRequestDTO refreshTokenRequestDTO){
        return refreshTokenService.findByToken(refreshTokenRequestDTO.getToken())
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUser)
                .map(userInfo -> {
                    List rls=new ArrayList<>();
                    rls.add(userInfo.getRoles().getLabel());
                    String accessToken = jwtUtilities.generateToken(userInfo.getUsername(), rls);
                    return JwtResponseDTO.builder()
                            .accessToken(accessToken)
                            .token(refreshTokenRequestDTO.getToken())
                            .build();
                }).orElseThrow(() ->new RuntimeException("Refresh Token is not in DB..!!"));
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public void UpdateUser(@PathVariable Long id, @RequestBody User u) {
        userService.UpdateUser(id,u);
    }

    @PutMapping("/{id}/flag")
    public ResponseEntity<User> flagUser(@PathVariable("id") Long id) {
        User user = userService.FlagUser(id);
        return ResponseEntity.ok(user);
    }
}
