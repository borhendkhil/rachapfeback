package org.example.eshopfinal.service.impl;

import org.example.eshopfinal.entities.Categorie;
import org.example.eshopfinal.service.ICategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.example.eshopfinal.repository.CategorieRepository;

import java.util.List;
@Service
public class CategorieService implements ICategorieService {
    @Autowired
    CategorieRepository RepCateg;
    @Override
    public Categorie AjouterCategorie(Categorie categ) {
        RepCateg.save(categ);
        return categ;
    }

    @Override
    public List<Categorie> getAllCategorie() {

        return (List<Categorie>) RepCateg.findAll();
    }

    @Override
    public void UpdateCategorie(Long idcateg, Categorie categ) {
        Categorie CategorieToUpdate = RepCateg.findById(idcateg).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"categorie existe pas dans la bd")

        );
        if(categ.getLibcateg()!=null &&!categ.getLibcateg().isEmpty()){
            CategorieToUpdate.setLibcateg(categ.getLibcateg());
        }


    }

    @Override
    public void supprimerCategorie(Long idcateg) throws ChangeSetPersister.NotFoundException {
       Categorie categorie = RepCateg.findById(idcateg)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        RepCateg.deleteById(idcateg);
        //  logger.info("Product {} is deleted", produit.getIdPROD());


    }


}
