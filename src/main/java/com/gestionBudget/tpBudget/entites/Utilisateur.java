package com.gestionBudget.tpBudget.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(name = "utilisateur")
public class Utilisateur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 50, message = "Texte trop long")
    private String nom;

    @Column(name = "prenom")
    @NotNull(message = "Remplisser les champs vides")
    @Size(max = 50, message = "Texte trop long")
    private String prenom;

    @Column(name = "email")
    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 50, message = "Texte trop long")
    @Email(message = "Entrer un email valide")
    private String email;

    @Column(name = "motDePasse")
    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 20, message = "Texte trop long")
    private String motDePasse;

    @OneToMany(mappedBy = "utilisateurDepense")
    private List<Depense> depensesUser;

    @OneToMany(mappedBy = "utilisateurAlert")
    private List<Alert> alertUser;

    @OneToMany(mappedBy = "")
    private List<Categorie> CategorieUser;

    @OneToMany(mappedBy = "utilisateurBudget")
    private List<Budget> BudgetUser;

    @OneToMany(mappedBy = "")
    private List<TypeDepense> typeDepenses;

}
