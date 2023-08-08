package com.gestionBudget.tpBudget.services;

import com.gestionBudget.tpBudget.entites.TypeDepense;

import java.util.List;

public interface ITypeDepenseService {

    TypeDepense createTypeDepense(TypeDepense typeDepense);
    TypeDepense  getTypeDepenseById(Long id);
    List<TypeDepense> getAllTypeDepenses();
    TypeDepense updateTypeDepense(Long id, TypeDepense typeDepense);
    void deleteTypeDepense(Long id);

}
