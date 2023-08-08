package com.gestionBudget.tpBudget.services;

import com.gestionBudget.tpBudget.entites.Alert;
import com.gestionBudget.tpBudget.repository.RepositoryAlert;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class
AlertServiceImpl implements IAlertService {

    private RepositoryAlert repositoryAlert;

    @Override
    public Alert save(Alert alert) {
        return null;
    }
}
