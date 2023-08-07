package com.gestionBudget.tpBudget.controllers;

import com.gestionBudget.tpBudget.entites.Depense;
import com.gestionBudget.tpBudget.services.IDepenseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/liste")
    public List<Depense> read(){
        return depenseService.lire();
    }
    @PutMapping("/modiffier/{idDepense}")
    public Depense modiffier(@PathVariable int idDepense,@RequestBody Depense depense){
        return depenseService.modifier(idDepense,depense);
    }

    @DeleteMapping("/supprimer/{idDepense}")
    public String supprimer(@PathVariable Long idDepense){
        return depenseService.supprimer(idDepense);
    }

}
