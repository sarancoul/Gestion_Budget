package com.gestionBudget.tpBudget.repository;

import com.gestionBudget.tpBudget.entites.Budget;
import com.gestionBudget.tpBudget.entites.Depense;
import com.gestionBudget.tpBudget.entites.TypeDepense;
import com.gestionBudget.tpBudget.entites.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface RepositoryDepense extends JpaRepository<Depense,Long> {
    Depense findByUtilisateurDepenseAndTypeDepenseAndDateAndBudgetDepense(Utilisateur utilisateur, TypeDepense typeDepense, LocalDate date, Budget budget);
    Depense findFirstByUtilisateurDepenseAndTypeDepenseAndBudgetDepenseOrderByDateDesc(Utilisateur utilisateur, TypeDepense typeDepense, Budget budget);

}
