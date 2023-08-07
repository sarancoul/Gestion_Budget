package com.gestionBudget.tpBudget.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Depense {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepense;

    @Column(name = "montant")
    @NotNull(message = "Remplissez les champs vides")
   // @Max(value = 100, message = "Montant trop eleve")
    private int montant;

    @Column(name = "description")
    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 100, message = "Texte trop long")
    private String description;

    @Column(name = "dateDebutDepense")
    @NotNull(message = "Remplissez les champs vides")
    private String dateDebutDepense;

    @Column(name = "dateFinDepense")
    @NotNull(message = "Remplissez les champs vides")
    private String dateFinDepense;

    @ManyToOne
    private Utilisateur utilisateurDepense;

    @ManyToOne
    private TypeDepense typeDepense;

    @ManyToOne
    private Budget budgetDepense;



}
