package com.example.dashboardbe.Domaine;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
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

   @JsonFormat(pattern="yyyy-MM-dd")
    //@JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dateNaissance;

    /*

    @Column(nullable = false)
    private Instant dateCreation;
    @Column(nullable = false)
    private Instant dateDerniereModification;
    @Column(nullable = false)
    private Instant dateDernièreModificationDuStatutDuCompte;
    @Column(nullable = false)
    private Instant dateDernierChangementMDP;
    @Column(nullable = false)
    private Instant tokenDeReinitialisationDuMDP;



     */






    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(min=6, max = 100)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<ROLES> roles= new HashSet<>();

    @OneToOne
    private RefreshToken token;



    @OneToMany( targetEntity=Product.class, mappedBy="user" )
    private Set<Product> produit = new HashSet<>();
/*

    public USER_DETAILS(String username, String photo, String nom, String prenom, String telephonePrincipale,
                        String telephoneSecondaire, String adresse, String creePar, String profilUtilisateur,
                        String statutDuCompte, String statutDuMDP, String desactivePar, Instant dateNaissance,
                        Instant dateCreation, Instant dateDerniereModification, Instant dateDernièreModificationDuStatutDuCompte,
                        Instant dateDernierChangementMDP, Instant tokenDeReinitialisationDuMDP, String email, String password) {
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



 */
public USER_DETAILS(String username, String photo, String nom, String prenom, String telephonePrincipale,
                    String telephoneSecondaire, String adresse, String creePar, String profilUtilisateur,
                    String statutDuCompte, String statutDuMDP, String desactivePar, String email, String password
                    ,LocalDate dateNaissance) {
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
    this.email = email;
    this.password = password;
    this.dateNaissance = dateNaissance;
}

}





