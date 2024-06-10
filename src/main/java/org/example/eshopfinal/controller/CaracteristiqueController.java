package org.example.eshopfinal.controller;

import org.example.eshopfinal.decorators.ActiveRole;
import org.example.eshopfinal.entities.CaracteristiquesProduits;
import org.example.eshopfinal.service.impl.CaracteristiquesProduitsServiceImpl;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/caracteristique")
@CrossOrigin(origins = "*")
public class CaracteristiqueController {

    private final CaracteristiquesProduitsServiceImpl caractProduitService;
    public CaracteristiqueController(CaracteristiquesProduitsServiceImpl service){
        this.caractProduitService=service;
    }
//role:Vendeur

    @GetMapping
    @ActiveRole(roles = {"ROLE_X", "ROLE_Y"})
    public List<CaracteristiquesProduits> GetAllCaract(){
        List<CaracteristiquesProduits> list=caractProduitService.getAllCract();
        return list;
    }
    @PostMapping("/add")
    public CaracteristiquesProduits AjouterCaract(@RequestBody CaracteristiquesProduits car){
        return  caractProduitService.ajoutercaract(car);
    }
    @DeleteMapping("delete/{id}")
    public void supprimercaract( @PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        caractProduitService.supprimercaract(id);

    }
    @PutMapping("update/{id}")
    public void UpdateCaract(@PathVariable Long id,@RequestBody CaracteristiquesProduits car){
        caractProduitService.updatecaract(id,car);
    }
}

