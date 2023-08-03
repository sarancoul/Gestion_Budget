package com.gestionBudget.tpBudget.entites;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

public class Alert {

    private Long idAlert;
    private int montantAtteind;

    @ManyToOne
    private Utilisateur utilisateurAlert;

    @OneToOne(mappedBy = "B")
    private Budget budgetAlert;
}
