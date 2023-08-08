package com.gestionBudget.tpBudget.services;

import com.gestionBudget.tpBudget.entites.TypeDepense;
import com.gestionBudget.tpBudget.exception.exception_type_depense;
import com.gestionBudget.tpBudget.repository.RepositoryTypeDepense;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TypeDepenseServiceImpl implements ITypeDepenseService {

    private RepositoryTypeDepense repositoryTypeDepense;

    @Override
    public TypeDepense createTypeDepense(TypeDepense typeDepense) {
        return repositoryTypeDepense.save(typeDepense);
    }

    @Override
    public TypeDepense getTypeDepenseById(Long id) {
        return repositoryTypeDepense.findById(id).orElseThrow(() ->new exception_type_depense("Type de depenses non trouver avc l'Id" +id));
    }

    @Override
    public List<TypeDepense> getAllTypeDepenses() {
        return repositoryTypeDepense.findAll();
    }

    @Override
    public TypeDepense updateTypeDepense(Long id, TypeDepense typeDepense) {
        TypeDepense existingTypeDepense = repositoryTypeDepense.findById(id).orElse(null);
        if (existingTypeDepense != null){
            existingTypeDepense.setNomTypeDepense(typeDepense.getNomTypeDepense());
            return repositoryTypeDepense.save(existingTypeDepense);
        }

        return null;
    }

    @Override
    public void deleteTypeDepense(Long id) {
        TypeDepense typeDepense = getTypeDepenseById(id);
        repositoryTypeDepense.deleteById(id);

    }
}
