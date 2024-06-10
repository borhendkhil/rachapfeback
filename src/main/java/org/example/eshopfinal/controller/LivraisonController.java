//package org.example.eshopfinal.controller;
/*
import lombok.RequiredArgsConstructor;
import org.example.eshopfinal.entities.Livraison;
import org.example.eshopfinal.service.LivraisonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/livraison")
@RequiredArgsConstructor
public class LivraisonController {
    @Autowired
    LivraisonServiceImpl LivraisonService;
    @GetMapping

    public List<Livraison> getAllLivraison(){
        List<Livraison> list=LivraisonService.getAlllivraison();
        return list;

    }
    @PostMapping("/add")
    public Livraison AjouterLivraison(@RequestBody Livraison l){
        return LivraisonService.ajouterlivraison(l);
    }
    @PutMapping("/{id}")
    public void FlagLivraison(@PathVariable Long id) {

        LivraisonService.desactiverlivraison(id);
    }
    @PutMapping("update/{id}")
    public void UpdateLivraison( @PathVariable Long id,@RequestBody Livraison l){
        LivraisonService.updatelivraison(id,l);
    }
}


 */