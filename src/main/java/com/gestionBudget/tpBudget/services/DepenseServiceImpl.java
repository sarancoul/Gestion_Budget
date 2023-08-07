package com.gestionBudget.tpBudget.services;

import com.gestionBudget.tpBudget.entites.Depense;
import com.gestionBudget.tpBudget.repository.RepositoryDepense;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepenseServiceImpl implements IDepenseService {
    private RepositoryDepense repositoryDepense;

    @Override
    public String creer(Depense depense) {
        repositoryDepense.save(depense);
        return "Depence effectuer";
    }

    @Override
    public List<Depense> lire() {
        return repositoryDepense.findAll();
    }

    @Override
    public Optional<Depense> modiffier(Long idDepense, Depense depense) {
        return repositoryDepense.findById(idDepense)
                .map(s->{
                    s.setMontant(depense.getMontant());
                    s.setDescription(depense.getDescription());
                    s.setDateDebutDepense(depense.getDateDebutDepense());
                    s.setDateFinDepense(depense.getDateFinDepense());
                    return repositoryDepense.save(s);
                });
    }

    @Override
    public String supprimer(Long idDepense) {
        repositoryDepense.deleteById(idDepense);
        return "Depense supprimer";
    }

}
