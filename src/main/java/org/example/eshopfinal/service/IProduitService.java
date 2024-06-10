package org.example.eshopfinal.service;

import java.util.List;

import org.example.eshopfinal.entities.Produit;
import org.springframework.data.crossstore.ChangeSetPersister;

public interface IProduitService {
    Produit ajouterproduit(Produit p);
    void updateproduit(Produit p,Long idprod);
    void supprimerProduit(Long idprod) throws ChangeSetPersister.NotFoundException;
    List <Produit> getAllProduit();
    Produit getProduitById(Long id);
    Produit getProduitByNom(String nom);
    List<Produit> getProduitByCategorie(Long idcat);
    List<Produit> getProduitByMarque(Long id);

}
