package com.example.dashboardbe.payload.response;


import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Data
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String refreshToken;
    private Long id;
    private String username;
    private String email;
    private String photo;

    private String   nom;
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





    private List<String> role;



        public JwtResponse(String accessToken, String refreshToken, Long id,
                String username, String email, String photo,
                String nom, String prenom, String telephonePrincipale, String telephoneSecondaire,
                String adresse, String creePar, String profilUtilisateur, String statutDuCompte,
                String statutDuMDP, String desactivePar, Date dateNaissance, Date dateCreation,
                 Date dateDerniereModification, Date dateDernièreModificationDuStatutDuCompte,
                Date dateDernierChangementMDP, Date tokenDeReinitialisationDuMDP,
                  List<String> role) {

            this.token = accessToken;
            this.refreshToken = refreshToken;
            this.id = id;
            this.username = username;
            this.email = email;
            this.photo=photo;
            this.nom = nom;
            this.prenom = prenom ;
            this.telephonePrincipale = telephonePrincipale ;
            this.telephoneSecondaire = telephoneSecondaire;
            this.adresse = adresse;
             this.creePar = creePar;
        this.profilUtilisateur = profilUtilisateur;
        this.statutDuCompte = statutDuCompte;
        this.statutDuMDP = statutDuMDP;
        this.desactivePar = desactivePar;
        this.dateNaissance = dateNaissance;
        this.dateCreation = dateCreation;
        this.dateDerniereModification = dateDerniereModification;
        this.dateDernièreModificationDuStatutDuCompte = dateDernièreModificationDuStatutDuCompte;
        this.dateDernierChangementMDP = dateDernierChangementMDP;
        this.tokenDeReinitialisationDuMDP = tokenDeReinitialisationDuMDP;


            this.role = role;

        }



    public String getToken() {
        return token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
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

    public List<String> getRole() {
        return role;
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
