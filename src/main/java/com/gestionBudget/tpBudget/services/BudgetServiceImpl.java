package com.gestionBudget.tpBudget.services;

import com.gestionBudget.tpBudget.repository.RepositoryBudget;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BudgetServiceImpl implements IBudgetService {
    private RepositoryBudget repositoryBudget;
}
