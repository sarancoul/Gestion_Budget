package com.gestionBudget.tpBudget;

import com.gestionBudget.tpBudget.entites.Depense;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class alertBudget {
    private final ScheduledExecutorService execute = Executors.newScheduledThreadPool(2);
    private final Depense depense; //injection de depense

    public alertBudget (Depense depense){
        this.depense=depense;
    }

    public void startAlert(){
        execute.scheduleAtFixedRate(()->verifierAlertBudget(),0, 2, TimeUnit.HOURS );
    }

    private void verifierAlertBudget (){
        double montantTotalBudget =depense.getMontant();
        double montantActuel = depense.getMontant();
        double pourcentageAtteint = (montantActuel/montantTotalBudget)*100;

        if (pourcentageAtteint>=80){
            System.out.println("Le montant du budget est à" + pourcentageAtteint +"%. ");
        }

    }

    public void stopAlert(){
        execute.shutdown();
    }
}
