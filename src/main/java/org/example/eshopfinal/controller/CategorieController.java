package org.example.eshopfinal.controller;

import lombok.RequiredArgsConstructor;
import org.example.eshopfinal.entities.Categorie;
import org.example.eshopfinal.service.impl.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/categorie")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CategorieController {
//vendeur
@Autowired
CategorieService categorieService;
    @GetMapping
    public List<Categorie> getAllCategorie() {
        List<Categorie> list = categorieService.getAllCategorie();
        return list;
    }
    @PostMapping("/add")
    public Categorie AjouterCategorie(@RequestBody Categorie categ){
        return categorieService.AjouterCategorie(categ);
    }
    @PutMapping("/{id}")
    public  void UpdateCateg(@PathVariable Long id, @RequestBody Categorie categ){
        categorieService.UpdateCategorie(id, categ);

    }
    @DeleteMapping("delete/{id}")
     public void supprimerCategorie( @PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        categorieService.supprimerCategorie(id);
    }
}
