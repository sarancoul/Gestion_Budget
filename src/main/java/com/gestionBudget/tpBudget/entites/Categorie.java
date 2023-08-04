package com.gestionBudget.tpBudget.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Categorie {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategory;

    private String nom;

    @OneToMany(mappedBy = "categorieBudget")
    private List<Budget> budgetCategorie;

    @ManyToOne
    private Utilisateur utilisateurCategorie;


}
