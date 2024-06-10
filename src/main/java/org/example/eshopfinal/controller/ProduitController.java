package org.example.eshopfinal.controller;

import lombok.RequiredArgsConstructor;
import org.example.eshopfinal.entities.Produit;
import org.example.eshopfinal.service.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;


@RestController
@RequestMapping("api/v1/produit")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProduitController {
    //ajout:logisticien
    //modification & suppression:Vendeur
    @Autowired
    IProduitService produitService;

    @GetMapping

    public List<Produit> getAllProduit() {
        List<Produit> list = produitService.getAllProduit();
        return list;
    }
    @PostMapping("/add")
    public Produit AjouterProduit(@RequestBody Produit p){
        return  produitService.ajouterproduit(p);
    }
    @DeleteMapping("delete/{id}")
    public void supprimerProduit( @PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        produitService.supprimerProduit(id);

    }

    @PutMapping("update/{id}")
    public void UpdateProduit( @RequestBody Produit p , @PathVariable Long id){
        produitService.updateproduit(p,id);}

    @GetMapping("/{id}")
    public Produit getProduitById(@PathVariable Long id){
        return produitService.getProduitById(id);
    }
    @GetMapping("/nom/{nom}")
    public Produit getProduitByNom(@PathVariable String nom){
        return produitService.getProduitByNom(nom);
    }
    @GetMapping("/categorie/{idcat}")
    public List<Produit> getProduitByCategorie(@PathVariable Long idcat){
        return produitService.getProduitByCategorie(idcat);
    }
    @GetMapping("/marque/{idmarque}")
    public List<Produit> getProduitByMarque(@PathVariable Long idmarque){
        return produitService.getProduitByMarque(idmarque);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Produit> saveProduit(@RequestParam("file") MultipartFile file,
                                               @RequestParam("nomprod") String nomprod) throws IOException, IOException {
        Produit produit = new Produit();
        produit.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        produit.setNomprod(nomprod);
        produitService.ajouterproduit(produit);
        return new ResponseEntity<>(produit, HttpStatus.CREATED);
    }



}
