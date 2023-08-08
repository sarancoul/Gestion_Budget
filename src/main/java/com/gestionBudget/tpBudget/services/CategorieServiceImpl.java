package com.gestionBudget.tpBudget.services;

import com.gestionBudget.tpBudget.entites.Categorie;
import com.gestionBudget.tpBudget.repository.RepositoryCategorie;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategorieServiceImpl implements ICategorieService {

    private RepositoryCategorie repositoryCategorie;

    @Override
    public Categorie ajouter(Categorie categorie) {
        return repositoryCategorie.save(categorie);
    }

    @Override
    public List<Categorie> lire() {
        return repositoryCategorie.findAll();
    }

    @Override
    public Categorie afficher(Long idCategie) {
        return repositoryCategorie.findById(idCategie).orElseThrow(
                ()-> new EntityNotFoundException("Identifiant n'existe pas"));
    }


    @Override
    public Categorie mofifier(Long idCategorie, Categorie categorie) {
        return repositoryCategorie.findById(idCategorie)
                .map(c-> {
                    c.setNom(categorie.getNom());
                    return repositoryCategorie.save(c);
                }).orElseThrow(()-> new RuntimeException(("Categorie modifier")));
    }

    @Override
    public String delete(Long idCategorie) {
        repositoryCategorie.deleteById(idCategorie);
        return "Categorie supprimer";
    }
}
