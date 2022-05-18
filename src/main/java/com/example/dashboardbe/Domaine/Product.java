package com.example.dashboardbe.Domaine;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String image;
    private String intituleProduit;
    private String proposePar;
    private String support;
    private LocalDate dateDeCreation;
    private String statut;


    @ManyToOne @JoinColumn(name="user_id", nullable=false)
    private User user;
}

