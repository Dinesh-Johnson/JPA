package com.xworkz.registraition.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UserDTO {

    private Integer id;

    @NotBlank
    @Size(min = 3,max = 20)
    private String name;

    @NotBlank
    @Email
    private String email;

    @Min(10)
    private Long mobile;

    @NotBlank
    private String dob;

    @NotBlank
    private String gender;

    @NotBlank
    private String state;

    @NotBlank
    private String address;

    @NotBlank
    private String password;

    @NotBlank
    private String confirmPassword;
}
