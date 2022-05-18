package com.example.dashboardbe.Domaine;


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
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String username;


    private String photo;
    private String nomComplet;
    private  String telephone;
    private String statut ;

    private LocalDate creationDate;
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
    private Set<Role> roles= new HashSet<>();

    @OneToOne
    private RefreshToken token;






    public User(String username, String email, String password, String photo,String nomComplet, String telephone ,String statut ,LocalDate creationDate ) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.photo = photo;
        this.nomComplet = nomComplet;
        this.telephone = telephone;
        this.statut = statut;
        this.creationDate = creationDate;

    }
}

