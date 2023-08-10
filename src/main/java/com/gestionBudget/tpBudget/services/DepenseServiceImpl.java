package com.gestionBudget.tpBudget.services;

import com.gestionBudget.tpBudget.entites.Budget;
import com.gestionBudget.tpBudget.entites.Depense;
import com.gestionBudget.tpBudget.entites.TypeDepense;
import com.gestionBudget.tpBudget.entites.Utilisateur;
import com.gestionBudget.tpBudget.repository.RepositoryDepense;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepenseServiceImpl implements IDepenseService {
    private RepositoryDepense repositoryDepense;

    @Override
    public String creer(Depense depense) {
        LocalDate dateDepense = depense.getDate();
        TypeDepense typeDepense = depense.getTypeDepense();
        Utilisateur utilisateurDepense = depense.getUtilisateurDepense();
        Budget budgetDepense = depense.getBudgetDepense();
        Depense depenseTest = null;
        if (dateDepense.isBefore(depense.getDate()) || dateDepense.isAfter(LocalDate.now())){
            return "Entree une date valide";
        }
        switch (typeDepense.getNomTypeDepense()){
            case "quotidien":
                depenseTest = repositoryDepense.findByUtilisateurDepenseAndTypeDepenseAndDateAndBudgetDepense(utilisateurDepense,typeDepense,dateDepense,budgetDepense);
                if (depenseTest!=null){
                    return "vous avez deja effectuee votre depense quotidien !";
                }
                break;
            case "hebdomadaire":
                depenseTest = repositoryDepense.findFirstByUtilisateurDepenseAndTypeDepenseAndBudgetDepenseOrderByDateDesc(utilisateurDepense,typeDepense,budgetDepense);
                if (depenseTest!=null){
                    if (depenseTest.getDate().plusDays(7).isAfter(LocalDate.now())){
                        return "vous avez deja effectuee votre depense hebdomadaire !";
                    }
                }
                break;
            case "mensuel":
                depenseTest = repositoryDepense.findFirstByUtilisateurDepenseAndTypeDepenseAndBudgetDepenseOrderByDateDesc(utilisateurDepense,typeDepense,budgetDepense);
                if (depenseTest!=null){
                    if (depenseTest.getDate().plusDays(30).isAfter(LocalDate.now())){
                        return "vous avez deja effectuee votre depense hebdomadaire !";
                    }
                }
                break;
            default:
                return "Ce type de depense n'existe pas !";
        }
        repositoryDepense.save(depense);
        return "Depense enregistre";
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
                    s.setDate(depense.getDate());
                    return repositoryDepense.save(s);
                });
    }

    @Override
    public String supprimer(Long idDepense) {
    Optional<Depense> depenseOptional = repositoryDepense.findById(idDepense);
    if (depenseOptional.isPresent()){
        repositoryDepense.deleteById(idDepense);
        return "Depense supprimer avec succès";
    }else {
        return "La Depense avec L'ID "+ idDepense + " n'existe pas";
    }
    }

}
