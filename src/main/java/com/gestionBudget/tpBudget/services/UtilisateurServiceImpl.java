package com.gestionBudget.tpBudget.services;

import com.gestionBudget.tpBudget.repository.RepositoryUtilisateur;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements IUtilisateurService {

    private RepositoryUtilisateur repositoryUtilisateur;
}
