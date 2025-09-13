package com.example.task_management.services;

import com.example.task_management.dto.authenticationDto.LoginResponse;
import com.example.task_management.dto.authenticationDto.UserLoginRequest;
import com.example.task_management.enums.UserRole;
import com.example.task_management.dto.authenticationDto.UserRegistrationRequest;
import com.example.task_management.exception.ApiException;
import com.example.task_management.exception.InvalidCredentialsException;
import com.example.task_management.models.Role;
import com.example.task_management.models.User;
import com.example.task_management.repository.RoleRepository;
import com.example.task_management.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;


    @Transactional
    public String registerUser(UserRegistrationRequest request) {
        UserRole roleName =request.isAdmin() ? UserRole.ADMIN : UserRole.USER;
        Role role = roleRepository.findByName(roleName)
                .orElseThrow(() -> new ApiException("Role not found", HttpStatus.NOT_FOUND));
        if(userRepository.existsByEmail(request.email())){
            throw  new ApiException("Email already exists" , HttpStatus.BAD_REQUEST);
        }

        User user = User.builder()
                .name(request.name())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .roles(Set.of(role))
                .build();

        userRepository.save(user);
        return "User registered successfully";
    }


    public LoginResponse loginUser(UserLoginRequest request) {
        performAuthentication(request);
        User user = userRepository.findByEmail(request.email())
                .orElseThrow(()-> new ApiException("email not found",HttpStatus.NOT_FOUND));
        return generateTokensAndBuildResponse(user);

    }

    private void performAuthentication(UserLoginRequest request){
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.email(), request.password())
            );
        } catch (Exception e) {
            throw new InvalidCredentialsException("Invalid email or password");
        }
    }

    private LoginResponse generateTokensAndBuildResponse(User user) {
        String jwtToken = jwtService.generateToken(user);

        return LoginResponse.builder()
                .token(jwtToken)
                .expiresIn(jwtService.getExpirationTime())
                .massage("Login successful")
                .build();
    }
}
