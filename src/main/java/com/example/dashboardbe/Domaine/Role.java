package com.example.dashboardbe.Domaine;


import lombok.*;
import javax.persistence.*;
import java.util.Set;




/** Entity Role porte les roles  ...*/

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;





}
