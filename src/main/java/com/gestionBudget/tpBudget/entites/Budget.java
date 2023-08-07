package com.gestionBudget.tpBudget.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Budget {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titre")
    @NotNull(message = "Remplisser les champs vides")
    @Size(max = 50, message = "Texte trop long")
    private String titre;

    @Column(name = "montant")
    @NotNull(message = "Remplissez les champs vides")
    @Min(value = 100, message = "Montant trop eleve")
    private int montant;

    @Column(name = "dateDebut")
    @NotNull(message = "Remplissez les champs vides")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Column(name = "dateFin")
    @NotNull(message = "Remplissez les champs vides")
    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @OneToMany(mappedBy = "budgetAlert")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Alert> alertBudget;

    @ManyToOne
    @JsonIgnore
    private Utilisateur utilisateurBudget;

    @ManyToOne
    @JsonIgnore
    private Categorie categorieBudget;

    @OneToMany(mappedBy = "budgetDepense")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Depense> depenseBudget;



}
