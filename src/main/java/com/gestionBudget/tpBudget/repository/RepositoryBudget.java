package com.gestionBudget.tpBudget.repository;

import com.gestionBudget.tpBudget.entites.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface RepositoryBudget extends JpaRepository<Budget,Long> {

//    chercher budget par titre unique
    Budget findByTitre(String titre);

    Budget findByMontant(int montant);

//    chercher un budget par date de Debut
    Budget findByIdBudget(Long idBudget);


}
