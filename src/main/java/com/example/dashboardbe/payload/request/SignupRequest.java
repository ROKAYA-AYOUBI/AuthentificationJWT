package com.example.dashboardbe.payload.request;


import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
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
    private String nom;
    private String prenom;
    private  String telephonePrincipale ;
    private  String telephoneSecondaire;
    private String adresse;

    private String creePar;

    private String profilUtilisateur;
    private String statutDuCompte  ;
    private String statutDuMDP;
    private String desactivePar;

    private LocalDate  dateNaissance;
/*
    private Instant dateNaissance;
    private Instant dateCreation;
    private Instant dateDerniereModification;
    private Instant dateDernièreModificationDuStatutDuCompte;
    private Instant dateDernierChangementMDP;
    private Instant tokenDeReinitialisationDuMDP;




 */

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoto() {
        return photo;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelephonePrincipale() {
        return telephonePrincipale;
    }

    public String getTelephoneSecondaire() {
        return telephoneSecondaire;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getCreePar() {
        return creePar;
    }

    public String getProfilUtilisateur() {
        return profilUtilisateur;
    }

    public String getStatutDuCompte() {
        return statutDuCompte;
    }

    public String getStatutDuMDP() {
        return statutDuMDP;
    }

    public String getDesactivePar() {
        return desactivePar;
    }

    public LocalDate  getDateNaissance() {
        return dateNaissance;
    }
}
