package com.gestionBudget.tpBudget.services;

import com.gestionBudget.tpBudget.entites.Categorie;

import java.util.List;

public interface ICategorieService {

    Categorie ajouter(Categorie categorie);

    List<Categorie> lire();

    Categorie afficher(Long idCategie);

    Categorie mofifier(Long idCategorie, Categorie categorie);

    String delete(Long idCategorie);

}
