package com.cemre.demo.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    @NotNull(message = "Kullanıcı adı boş olamaz")
    private String username;

    @Email(message = "Geçerli email adresi giriniz")
    private String email;

    @Size(min= 6  , message = "Şifre en az 6 karakterli olmalı")
    private String password;
}
