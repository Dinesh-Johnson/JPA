package com.xworkz.passport.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class PassportDTO {

    private Integer passportId;

    @NotBlank
    private String passportOffice;

    @NotBlank
    @Size(min = 3,max = 20)
    private String name;

    @NotBlank
    @Size(min = 3,max = 20)
    private String surname;

    @NotNull
    private String dob;

    @Email
    private String email;

    @NotBlank
    @Min(10)
    private Long mobile;

    @NotBlank
    private String loginId;

    @NotBlank
    private String loginIdSameAsEmail;

    @NotBlank
    @Size(min = 8,max = 12)
    private String password;

    @NotBlank
    @Size(min = 8,max = 12)
    private String confirmPassword;

    @NotBlank
    private String hintQuestion;

    @NotBlank
    @Size(min = 3)
    private String hintAnswer;


}
