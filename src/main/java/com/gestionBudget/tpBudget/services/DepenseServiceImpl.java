package com.gestionBudget.tpBudget.services;

import com.gestionBudget.tpBudget.repository.RepositoryDepense;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepenseServiceImpl implements IDepenseService {
    private RepositoryDepense repositoryDepense;
}
