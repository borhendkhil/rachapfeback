package org.example.eshopfinal.controller;

import lombok.RequiredArgsConstructor;
import org.example.eshopfinal.entities.Couleur;
import org.example.eshopfinal.service.impl.CouleurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/couleur")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
//Logisticien
public class CouleurController {
    @Autowired
    CouleurServiceImpl CouleurService;
    @GetMapping
    public List<Couleur> getAllCouleur(){
        List<Couleur> list=CouleurService.getAllcouleur();
        return  list;
    }
    @PostMapping("/add")
    public Couleur AjouterCouleur(@RequestBody Couleur c){
        return CouleurService.ajoutercouleur(c);
    }
    @PutMapping("/{id}")
    public void DesactiverCouleur(@PathVariable String id) {
        CouleurService.desactiver(id);
    }
    @PutMapping("update/{id}")
    public void UpdateCouleur(@PathVariable String id, @RequestBody Couleur c){
        CouleurService.updatecouleur(id,c);
    }
    @GetMapping("/libelle/{libcl}")

    public Couleur getByLibelle(@PathVariable String libcl){
        return CouleurService.getbylibcl(libcl);
    }
    @GetMapping("/id/{id}")
    public Couleur getById(@PathVariable Long id){
        return CouleurService.getbyid(id);
    }

}

