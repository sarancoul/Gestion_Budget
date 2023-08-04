package com.gestionBudget.tpBudget.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class TypeDepense {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTypeDepense;

    @Column(name = "nomTypeDepense")
    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 50, message = "Texte trop long")
    private String nomTypeDepense;

    @ManyToOne
    private Utilisateur utilisateurType;

    @OneToMany(mappedBy = "typeDepense")
    private List<Depense> depensesType;

}
