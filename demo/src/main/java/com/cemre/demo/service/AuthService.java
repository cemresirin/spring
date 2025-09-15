package com.cemre.demo.service;

import com.cemre.demo.dto.auth.RegisterRequest;
import com.cemre.demo.dto.auth.RegisterResponse;

public interface AuthService {

    RegisterResponse register (RegisterRequest registerRequest);
}
