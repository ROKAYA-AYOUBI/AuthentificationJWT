package com.example.dashboardbe.Domaine;


import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;




/** Entity User contine les information necessaire ...*/


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(	name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class USER_DETAILS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String username;

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








    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<USER_ROLES> roles= new HashSet<>();

    @OneToOne
    private RefreshToken token;

    @OneToMany( targetEntity=Product.class, mappedBy="user" )
    private Set<Product> produit = new HashSet<>();


    public USER_DETAILS(String username, String photo, String nom, String prenom, String telephonePrincipale,
                        String telephoneSecondaire, String adresse, String creePar, String profilUtilisateur,
                        String statutDuCompte, String statutDuMDP, String desactivePar, Date dateNaissance,
                        Date dateCreation, Date dateDerniereModification, Date dateDernièreModificationDuStatutDuCompte,
                        Date dateDernierChangementMDP, Date tokenDeReinitialisationDuMDP, String email, String password) {
        this.username = username;
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
        this.dateNaissance = dateNaissance;
        this.dateCreation = dateCreation;
        this.dateDerniereModification = dateDerniereModification;
        this.dateDernièreModificationDuStatutDuCompte = dateDernièreModificationDuStatutDuCompte;
        this.dateDernierChangementMDP = dateDernierChangementMDP;
        this.tokenDeReinitialisationDuMDP = tokenDeReinitialisationDuMDP;
        this.email = email;
        this.password = password;
    }




}





