package com.gestionBudget.tpBudget.services;

import com.gestionBudget.tpBudget.entites.Budget;
import com.gestionBudget.tpBudget.entites.Depense;
import com.gestionBudget.tpBudget.entites.TypeDepense;
import com.gestionBudget.tpBudget.entites.Utilisateur;
import com.gestionBudget.tpBudget.exception.NotFoundException;
import com.gestionBudget.tpBudget.repository.RepositoryDepense;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepenseServiceImpl implements IDepenseService {
    @Autowired
    private RepositoryDepense repositoryDepense;
    @Autowired
    private IBudgetService budgetService;

    @Override
    public Depense creer(Depense depense) {

        LocalDate dateDepense = depense.getDate();  //recupere date de depense

        TypeDepense typeDepense = depense.getTypeDepense();  //recupere date de TypeDepense

        Utilisateur utilisateurDepense = depense.getUtilisateurDepense();    //recupere date de utilsateurDepense

        Budget budgetDepense = depense.getBudgetDepense();   //recupere date de budgetDepense

        LocalDate dateDebut = budgetDepense.getDateDebut().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();     // convertir date en local date

        Depense depenseTest = null;
//        Si la date de depense est avant a la date de debut du budget et la date de depense est apres a la date maintement
        if (dateDepense.isBefore(dateDebut) || dateDepense.isAfter(LocalDate.now())){
            throw new NotFoundException(" le budget de votre depense n'est pas valide, verifier vos dates");
        }
            switch (typeDepense.getNomTypeDepense()){
                case "quotidien":
                    depenseTest = repositoryDepense.findByUtilisateurDepenseAndTypeDepenseAndDateAndBudgetDepense(utilisateurDepense,typeDepense,dateDepense,budgetDepense);
                    if (depenseTest!=null){
                        throw new NotFoundException("vous avez deja effectuee votre depense quotidien !");
                    }
                    budgetService.montantReduit(depense);
                    break;
                case "hebdomadaire":
                    depenseTest = repositoryDepense.findFirstByUtilisateurDepenseAndTypeDepenseAndBudgetDepenseOrderByDateDesc(utilisateurDepense,typeDepense,budgetDepense);
                    if (depenseTest!=null){
                        if (depenseTest.getDate().plusDays(7).isAfter(LocalDate.now())){
                            throw new NotFoundException("vous avez deja effectuee votre depense hebdomadaire !");
                        }
                    }
                    budgetService.montantReduit(depense);
                    break;
                case "mensuel":
                    depenseTest = repositoryDepense.findFirstByUtilisateurDepenseAndTypeDepenseAndBudgetDepenseOrderByDateDesc(utilisateurDepense,typeDepense,budgetDepense);
                    if (depenseTest!=null){
                        if (depenseTest.getDate().plusDays(30).isAfter(LocalDate.now())){
                            throw new NotFoundException("vous avez deja effectuee votre depense mensuel !");
                        }
                    }
                    budgetService.montantReduit(depense);
                    break;
                default:
                    throw new NotFoundException("Ce type de depense n'existe pas !");
            }
        return repositoryDepense.save(depense);
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
        repositoryDepense.deleteById(idDepense);
        return "Depense supprimer";
    }

}
