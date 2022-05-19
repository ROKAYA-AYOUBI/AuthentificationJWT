package com.example.dashboardbe.Service.Impl;


import java.time.Instant;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


import com.example.dashboardbe.Domaine.USER_DETAILS;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import com.fasterxml.jackson.annotation.JsonIgnore;
@Data
public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String email;

    @JsonIgnore
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
/*
    private Instant dateNaissance;
    private Instant dateCreation;
    private Instant dateDerniereModification;
    private Instant dateDernièreModificationDuStatutDuCompte;
    private Instant dateDernierChangementMDP;
    private Instant tokenDeReinitialisationDuMDP;




 */


    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Long id, String username, String email, String password, String photo,
                           String nom, String prenom, String telephonePrincipale, String telephoneSecondaire,
                           String adresse, String creePar, String profilUtilisateur, String statutDuCompte, String statutDuMDP,
                           String desactivePar,  Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.photo = photo;
        this.nom = nom;
        this.prenom = prenom;
        this.telephonePrincipale = telephonePrincipale;
        this.telephoneSecondaire = telephoneSecondaire;
        this.adresse = adresse;
        this.creePar = creePar;
        this.profilUtilisateur = profilUtilisateur;
        this.statutDuCompte = statutDuCompte;
        this.statutDuMDP = statutDuMDP;
        this.desactivePar = desactivePar;

        this.authorities = authorities;
    }

    /*
    public UserDetailsImpl(Long id, String username, String email, String password,String photo
            ,String nom,String prenom ,String telephonePrincipale , String telephoneSecondaire,
                           String adresse,
                           Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.photo = photo;
        this.nom = nom;
        this.prenom = prenom;
        this.telephonePrincipale = telephonePrincipale ;
        this.telephoneSecondaire = telephoneSecondaire;
        this.adresse = adresse;
        this.authorities = authorities;
    }

 */



    public static UserDetailsImpl build(USER_DETAILS user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());


        return new UserDetailsImpl(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getPhoto(),
                user.getNom(),
                user.getPrenom(),
                user.getTelephonePrincipale(),
                user.getTelephoneSecondaire(),
                user.getAdresse(),
                user.getCreePar(),
                user.getProfilUtilisateur(),
                user.getStatutDuCompte(),
                user.getStatutDuMDP(),
                user.getDesactivePar(),

                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public String getPhoto() {
        return photo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }
}

