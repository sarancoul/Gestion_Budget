package com.gestionBudget.tpBudget.repository;

import com.gestionBudget.tpBudget.entites.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryBudget extends JpaRepository<Budget,Long> {

}
