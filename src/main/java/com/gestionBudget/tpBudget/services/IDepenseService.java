package com.gestionBudget.tpBudget.services;

import com.gestionBudget.tpBudget.entites.Depense;

import java.util.List;

public interface IDepenseService {

    String creer(Depense depense);

    List<Depense> lire();

    Depense modifier(int idDepense, Depense depense);

    String supprimer(Long idDepense);
}
