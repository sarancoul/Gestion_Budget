package com.gestionBudget.tpBudget.services;

import com.gestionBudget.tpBudget.entites.Depense;
import com.gestionBudget.tpBudget.repository.RepositoryDepense;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Depense modifier(int idDepense, Depense depense) {
        return repositoryDepense.findById((long) idDepense)
                .map(s->{
                    s.setMontant(depense.getMontant());
                    s.setDescription(depense.getDescription());
                    s.setDateDebutDepense(depense.getDateDebutDepense());
                    s.setDateFinDepense(depense.getDateFinDepense());
                    return repositoryDepense.save(s);
                }).orElseThrow(()->new RuntimeException("Depense non trouvé !"));
    }

    @Override
    public String supprimer(Long idDepense) {
        repositoryDepense.deleteById(idDepense);
        return "Depense supprimer";
    }

}
