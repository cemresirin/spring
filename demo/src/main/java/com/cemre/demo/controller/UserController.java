package com.cemre.demo.controller;

import com.cemre.demo.dto.auth.RegisterRequest;
import com.cemre.demo.dto.auth.RegisterResponse;
import com.cemre.demo.dto.request.UserRequest;
import com.cemre.demo.dto.response.UserResponse;
import com.cemre.demo.service.AuthService;
import com.cemre.demo.service.UserService;
import com.cemre.demo.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserServiceImpl userService;
    private final AuthService authService;
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserServiceImpl userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @PostMapping("/save")
    public UserResponse createUser(@Valid @RequestBody UserRequest request) {
        logger.info("User created");
        return userService.createUser(request);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@Valid @RequestBody RegisterRequest request) {
        logger.info("Registered User");
        RegisterResponse response = authService.register(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PutMapping("/update/{id}")
    public UserResponse updateUser(@PathVariable Long id, @Valid @RequestBody UserRequest request) {
        return userService.updateUser(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}



