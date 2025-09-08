package com.cemre.demo.service.impl;

import org.modelmapper.ModelMapper;
import com.cemre.demo.dto.request.UserRequest;
import com.cemre.demo.dto.response.UserResponse;
import com.cemre.demo.model.User;
import com.cemre.demo.repository.UserRepository;
import com.cemre.demo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public UserResponse createUser(UserRequest request) {
        User user = modelMapper.map(request , User.class);
        User savedUser=userRepository.save(user);
        return modelMapper.map(savedUser , UserResponse.class);
    }

    @Override
    public UserResponse getUser(Long id) {
        User getUser = userRepository.findById(id).orElse(null);
        UserResponse userResponse = modelMapper.map(getUser , UserResponse.class);
        return userResponse;

    }

    @Override
    @Transactional
    public UserResponse updateUser(Long id, UserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

        modelMapper.map(request, user);

        User updatedUser = userRepository.save(user);
        return modelMapper.map(updatedUser, UserResponse.class);

    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        User deleteUser = userRepository.findById(id).orElse(null);
        userRepository.delete(deleteUser);
    }
}


