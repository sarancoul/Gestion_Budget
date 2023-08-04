package com.gestionBudget.tpBudget.controllers;

import com.gestionBudget.tpBudget.entites.Depense;
import com.gestionBudget.tpBudget.services.IDepenseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/depence")
@AllArgsConstructor
public class DepenseController {

    private IDepenseService depenseService;     //injection de service


    @PostMapping("/creer")
    private String effectuer(@RequestBody Depense depense){
        depenseService.creer(depense);
        return "Depense creer";
    }

}
