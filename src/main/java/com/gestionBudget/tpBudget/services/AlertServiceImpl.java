package com.gestionBudget.tpBudget.services;

import com.gestionBudget.tpBudget.entites.Alert;
import com.gestionBudget.tpBudget.repository.RepositoryAlert;
import com.gestionBudget.tpBudget.repository.RepositoryBudget;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AlertServiceImpl implements IAlertService {

    private RepositoryAlert repositoryAlert;
    private RepositoryBudget repositoryBudget;

    @Override
    public Alert save(Alert alert) {
        return repositoryAlert.save(alert);
    }
}
