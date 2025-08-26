package com.cemre.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/one")
    public Map<String, String> getUser() {
        return Map.of(
                "id" , "1",
                "name" , "Cemre"
        );
    }
}
