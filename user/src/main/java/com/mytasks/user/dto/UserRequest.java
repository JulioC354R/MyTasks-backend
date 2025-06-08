package com.mytasks.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequest {

    @NotBlank(message = "Name is required!")
    private String name;

    @NotBlank(message = "Email  ")
    @Email(message = "Email invalid")
    private String email;
}
