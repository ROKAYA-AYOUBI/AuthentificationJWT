package com.example.dashboardbe.Domaine;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;

public class USER_PWD_HISTORY {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String Hash_Mdp;

    @Column(nullable = false)
    private Instant dateDeCreation;

    @Column(nullable = false)
    private Instant dateDeChangement;
}
