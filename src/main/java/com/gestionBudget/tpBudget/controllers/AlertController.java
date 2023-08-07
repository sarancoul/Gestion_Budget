package com.gestionBudget.tpBudget.controllers;

import com.gestionBudget.tpBudget.entites.Alert;
import com.gestionBudget.tpBudget.services.IAlertService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alert")
@AllArgsConstructor
public class AlertController {

    private IAlertService alertService;

    @PostMapping("/enregister")
    private Alert enregistrer(@RequestBody Alert alert){
        return alertService.save(alert);
    }
}
