package com.example.dashboardbe.Domaine;


import lombok.*;
import javax.persistence.*;


/** Entity Role porte les roles  ...*/

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class ROLES {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;





}
