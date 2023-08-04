package com.gestionBudget.tpBudget.services;

import com.gestionBudget.tpBudget.repository.RepositoryCategorie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategorieServiceImpl implements ICategorieService {

    private RepositoryCategorie repositoryCategorie;
}
