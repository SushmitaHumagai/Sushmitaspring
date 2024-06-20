package com.nextstep.springauth.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class SignUpModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Username should not be null")
    @NotBlank(message = "Username should not be blank")
    private String username;

    @NotNull(message = "First name should not be null")
    @NotBlank(message = "First name should not be blank")
    private String firstname;

    private String lastname;
    private String gender;

    @Email(message = "Email should be valid")
    @NotNull(message = "Email should not be null")
    @NotBlank(message = "Email should not be blank")
    private String email;

    @NotNull(message = "Password should not be null")
    @NotBlank(message = "Password should not be blank")
    private String password;

    private String profilePic;
    private String panNo;
    private String registrationNo;
    private String role;
}
