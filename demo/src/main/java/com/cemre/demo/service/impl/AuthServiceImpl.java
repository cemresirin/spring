package com.cemre.demo.service.impl;

import com.cemre.demo.dto.auth.RegisterRequest;
import com.cemre.demo.dto.auth.RegisterResponse;
import com.cemre.demo.jwt.JwtService;
import com.cemre.demo.model.User;
import com.cemre.demo.repository.UserRepository;
import com.cemre.demo.service.AuthService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        if(userRepository.findByUsername(registerRequest.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        User user = modelMapper.map(registerRequest , User.class);
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        User savedUser = userRepository.save(user);
        String token = jwtService.generateToken(savedUser);
        return new RegisterResponse("User registered successfully", token);

    }
}
