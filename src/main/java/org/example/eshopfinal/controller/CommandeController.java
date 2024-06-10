package org.example.eshopfinal.controller;

import lombok.RequiredArgsConstructor;
import org.example.eshopfinal.entities.Commande;
import org.example.eshopfinal.service.impl.CommandeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/commande")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CommandeController {
    //Vendeur
    @Autowired
   CommandeServiceImpl commandeService;
    @GetMapping
    public List<Commande> gelAllcommandes(){
        List<Commande> list=commandeService.getAllcommande();
        return list;
    }
    @PutMapping("commande/valider/{id}")
    public void ValiderCommande(@PathVariable Long id){

        commandeService.validercommande(id);
    }
    @GetMapping("commande/{id}")
    public Commande getCommandeById(@PathVariable Long id){
        return commandeService.getCommandeById(id);
    }

}

