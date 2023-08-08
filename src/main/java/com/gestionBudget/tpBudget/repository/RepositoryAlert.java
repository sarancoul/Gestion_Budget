package com.gestionBudget.tpBudget.repository;

import com.gestionBudget.tpBudget.entites.Alert;
import com.gestionBudget.tpBudget.entites.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RepositoryAlert extends JpaRepository<Alert,Long> {

    Long findByIdAlert(Long idAlert);
//    Alert findByUtilisateurAlertAndBudgetAlert(Long idUser,Long idBudget);
}
