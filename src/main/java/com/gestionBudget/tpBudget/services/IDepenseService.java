package com.gestionBudget.tpBudget.services;

import com.gestionBudget.tpBudget.entites.Depense;

import java.util.List;
import java.util.Optional;

public interface IDepenseService {

    Depense creer(Depense depense);

    List<Depense> lire();

    Optional<Depense> modiffier(Long idDepense, Depense depense);

    String supprimer(Long idDepense);
}
