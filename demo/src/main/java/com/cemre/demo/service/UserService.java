package com.cemre.demo.service;

import com.cemre.demo.dto.request.UserRequest;
import com.cemre.demo.dto.response.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequest request);
    UserResponse getUser(Long id);
    UserResponse updateUser(Long id , UserRequest request);
    void deleteUser(Long id);
}

