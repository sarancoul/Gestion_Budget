package com.gestionBudget.tpBudget.repository;

import com.gestionBudget.tpBudget.entites.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUtilisateur extends JpaRepository<Utilisateur,Long> {
}
