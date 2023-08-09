package com.gestionBudget.tpBudget.services;

import com.gestionBudget.tpBudget.entites.Budget;
import com.gestionBudget.tpBudget.entites.Depense;

import java.util.List;

public interface IBudgetService {

//    Definir un budget
    String creer(Budget budget);

    List<Budget> afficher();

    Budget lire(Long idBudget);

    String modifier(Budget budget);

    String supprimer(Long idBudget);

    void montantReduit(Depense depense);

}
