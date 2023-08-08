package com.gestionBudget.tpBudget.controllers;

import com.gestionBudget.tpBudget.entites.TypeDepense;
import com.gestionBudget.tpBudget.exception.exception_type_depense;
import com.gestionBudget.tpBudget.services.ITypeDepenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("type_depense")
@AllArgsConstructor
public class TypeDepenseController {
    private ITypeDepenseService typeDepenseService;
    @PostMapping("/create")
    public ResponseEntity<TypeDepense> createTypeDepense(@RequestBody TypeDepense typeDepense){
        TypeDepense createTypeDepense = typeDepenseService.createTypeDepense(typeDepense);
        return new ResponseEntity<>(createTypeDepense, HttpStatus.CREATED);


    }

    @GetMapping("/search/{id}")
    public TypeDepense getTypeDepenseById(@PathVariable Long id){
        return typeDepenseService.getTypeDepenseById(id);
    }


    @GetMapping
    public ResponseEntity<List<TypeDepense>> getAllTypeDepenses() {
        List<TypeDepense> typeDepenses = typeDepenseService.getAllTypeDepenses();
        return new ResponseEntity<>(typeDepenses, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TypeDepense> updateTypeDepense(@PathVariable Long id, @RequestBody TypeDepense typeDepense) {
        TypeDepense updatedTypeDepense = typeDepenseService.updateTypeDepense(id, typeDepense);
        if (updatedTypeDepense != null) {
            return new ResponseEntity<>(updatedTypeDepense, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTypeDepense(@PathVariable Long id, @RequestParam(required = false) boolean confirm) {
        if (!confirm) {
            return new ResponseEntity<>("Suppression annulée. Voulez-vous vraiment supprimer ce Type de Depense? ", HttpStatus.OK);
        }

        TypeDepense typeDepense = typeDepenseService.getTypeDepenseById(id);
        if (typeDepense == null){
            return new ResponseEntity<>("Le type d l'identifiant id n'existe pas ." , HttpStatus.NOT_FOUND);
        }

        typeDepenseService.deleteTypeDepense(id);
        return new ResponseEntity<>("Type de dépense supprimé avec succès.", HttpStatus.OK);
    }



    @ExceptionHandler(exception_type_depense.class)
    public ResponseEntity<String> handleTypeDepenseNotFoundException(exception_type_depense ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleOtherExceptions(Exception ex) {
        return new ResponseEntity<>("Une erreur s'est produite. Veuillez réessayer plus tard.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
