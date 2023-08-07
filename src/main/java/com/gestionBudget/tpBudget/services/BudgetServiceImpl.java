package com.gestionBudget.tpBudget.services;

import com.gestionBudget.tpBudget.entites.Budget;
import com.gestionBudget.tpBudget.repository.RepositoryBudget;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class BudgetServiceImpl implements IBudgetService {

    private RepositoryBudget repositoryBudget;      //  injection

    @Override
    public String creer(Budget budget) {
        Budget budget1 = repositoryBudget.findByTitre(budget.getTitre());
        if (budget1==null){
            Date dateFin = budget.getDateDebut();
            Calendar cd = Calendar.getInstance();
            cd.setTime(dateFin);
            cd.add(Calendar.DATE, 30);
            dateFin = cd.getTime();
            budget.setDateFin(dateFin);
            repositoryBudget.save(budget);
            return "Budget defini";
        }else {
            return "Budget existe deja !";
        }
    }

    @Override
    public List<Budget> afficher() {
        return repositoryBudget.findAll();
    }

    @Override
    public Budget lire(Long idBudget) {
        return  repositoryBudget.findById(idBudget).orElseThrow(
                ()-> new EntityNotFoundException("Identifiant n'existe pas !")
        );
    }

    @Override
    public String modifier(Budget budget) {
        Budget budget1 = repositoryBudget.findByTitre(budget.getTitre());
        if (budget1==null){
            repositoryBudget.save(budget);
            return "Budget modifie";
        }else {
            return "Budget n'existe pas";
        }
    }

    @Override
    public String supprimer(Long idBudget) {
        Budget budget = repositoryBudget.findByIdBudget(idBudget);
        if (budget==null){
            return "Identifiant incorrect";
        }else {
            repositoryBudget.deleteById(idBudget);
            return "Identifiant supprimer";
        }
    }


}
