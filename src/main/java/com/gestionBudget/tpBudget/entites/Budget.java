package com.gestionBudget.tpBudget.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Budget {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "montant")
    @NotNull(message = "Remplissez les champs vides")
    @Max(value = 100, message = "Montant trop eleve")
    private String montant;

    @Column(name = "mois")
    @NotNull(message = "Remplissez les champs vides")
    private String mois;

    @OneToMany(mappedBy = "budgetAlert")
    private List<Alert> alertBudget;

    @ManyToOne
    private Utilisateur utilisateurBudget;

    @ManyToOne
    private Categorie categorieBudget;

    @OneToMany(mappedBy = "budgetDepense")
    private List<Depense> depenseBudget;



}
