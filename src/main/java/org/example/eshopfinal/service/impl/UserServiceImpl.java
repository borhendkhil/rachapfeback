package org.example.eshopfinal.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.eshopfinal.dto.UserRequest;
import org.example.eshopfinal.dto.UserResponse;
import org.example.eshopfinal.entities.security.Role;
import org.example.eshopfinal.entities.security.User;

import org.example.eshopfinal.repository.RoleRepository;
import org.example.eshopfinal.service.IUserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.example.eshopfinal.repository.UserRepository;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    ModelMapper modelMapper = new ModelMapper();



    @Override
    public UserResponse saveUser(UserRequest userRequest) {
        if (userRequest.getUsername() == null) {
            throw new RuntimeException("Parameter username is not found in request..!!");
        } else if (userRequest.getPassword() == null) {
            throw new RuntimeException("Parameter password is not found in request..!!");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = userRequest.getPassword();
        String encodedPassword = encoder.encode(rawPassword);

        User user = modelMapper.map(userRequest, User.class);
        Role role=roleRepository.findById(userRequest.getRoleId()).orElse(null);
        System.out.println(role);
        System.out.println(userRequest);
        user=User.builder()
                .flag(true)
                .numTel(userRequest.getNumTel())
                .mail(userRequest.getMail())
                .username(userRequest.getUsername())
                .password(encodedPassword)
                .roles(role)
                .build();

        User savedUser = userRepository.save(user);
        System.out.println(savedUser);
        UserResponse userResponse = modelMapper.map(savedUser, UserResponse.class);
        return userResponse;
    }

    @Override
    public UserResponse getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String usernameFromAccessToken = userDetails.getUsername();

        Optional<User> userOptional = userRepository.findByUsername(usernameFromAccessToken);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            UserResponse userResponse = modelMapper.map(user, UserResponse.class);
            return userResponse;
        } else {
            throw new UsernameNotFoundException("User not found with username: " + usernameFromAccessToken);
        }
    }

    @Override
    public List<UserResponse> getAllUser() {
        List<User> users = (List<User>) userRepository.findAll();
        Type setOfDTOsType = new TypeToken<List<UserResponse>>(){}.getType();
        List<UserResponse> userResponses = modelMapper.map(users, setOfDTOsType);
        return userResponses;
    }
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User FlagUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        user.setFlag(!user.isFlag());
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void UpdateUser(Long id, User u) {
        User userEntityToUpdate = userRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"User existe pas dans la base de données")

        );
        if (u.getUsername() != null && !u.getUsername().isEmpty()){
            userEntityToUpdate.setUsername(u.getUsername());
        }

        if (u.getMail() != null && !u.getMail().isEmpty()){
            userEntityToUpdate.setMail(u.getMail());
        }
        if (u.getNumTel() != null ){
            userEntityToUpdate.setNumTel(u.getNumTel());
        }

        if (u.getPassword() != null && !u.getPassword().isEmpty()){
            userEntityToUpdate.setPassword(u.getPassword());
        }

    }

}


/*
    @Override
    public UserInfo getUserByRole(Role role) {
        return userRepository.findByRole(role);
    }

 */


