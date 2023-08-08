package com.gestionBudget.tpBudget.controllers;

import com.gestionBudget.tpBudget.entites.Categorie;
import com.gestionBudget.tpBudget.services.ICategorieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categorie")
@AllArgsConstructor
public class CategorieController {
    private ICategorieService categorieService;

    @PostMapping("/ajouter")
    public Categorie ajouter(@RequestBody Categorie categorie){
        return categorieService.ajouter(categorie);
    }

    @GetMapping("/lire")
    public List<Categorie> lire(){
        return categorieService.lire();
    }
    @PutMapping("/modifier{id}")
    public Categorie modifier(@PathVariable Long id,  @RequestBody Categorie categorie){
        return categorieService.mofifier(id,categorie );
    }
    @DeleteMapping("/supprimer{id}")
    public String delete(@PathVariable Long id){
        return categorieService.delete(id);
    }
}
