package com.example.dashboardbe.payload.request;


import java.time.LocalDate;
import java.util.Set;

import javax.validation.constraints.*;

public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;



    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
    private String photo;

    private String nomComplet;

    private String telephone;

    private String statut;

   private LocalDate creationDate;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getStatut() {
        return statut;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }
}
