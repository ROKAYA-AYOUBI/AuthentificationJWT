package com.example.dashboardbe.payload.request;


import lombok.Data;

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

    private Date dateNaissance;
    private Date dateCreation;
    private Date dateDerniereModification;
    private Date dateDernièreModificationDuStatutDuCompte;
    private Date dateDernierChangementMDP;
    private Date tokenDeReinitialisationDuMDP;




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

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public Date getDateDerniereModification() {
        return dateDerniereModification;
    }

    public Date getDateDernièreModificationDuStatutDuCompte() {
        return dateDernièreModificationDuStatutDuCompte;
    }

    public Date getDateDernierChangementMDP() {
        return dateDernierChangementMDP;
    }

    public Date getTokenDeReinitialisationDuMDP() {
        return tokenDeReinitialisationDuMDP;
    }
}
