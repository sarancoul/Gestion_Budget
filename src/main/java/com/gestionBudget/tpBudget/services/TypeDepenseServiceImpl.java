package com.gestionBudget.tpBudget.services;

import com.gestionBudget.tpBudget.repository.RepositoryTypeDepense;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TypeDepenseServiceImpl implements ITypeDepenseService {

    private RepositoryTypeDepense repositoryTypeDepense;
}
