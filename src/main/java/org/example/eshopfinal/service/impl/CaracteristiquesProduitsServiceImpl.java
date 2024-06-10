package org.example.eshopfinal.service.impl;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.example.eshopfinal.entities.CaracteristiquesProduits;
import jakarta.transaction.Transactional;
import org.example.eshopfinal.service.ICaracteristiquesProduitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import org.springframework.web.server.ResponseStatusException;
import org.example.eshopfinal.repository.CaracteristiquesProduitsRepository;

@Service
@RequiredArgsConstructor
public class CaracteristiquesProduitsServiceImpl implements ICaracteristiquesProduitsService {
    @Autowired

    CaracteristiquesProduitsRepository RepCarac;

    @Override
    public CaracteristiquesProduits ajoutercaract(CaracteristiquesProduits car) {
        RepCarac.save(car);
        return car;
    }

    @Override
    public void supprimercaract(Long codecar) throws ChangeSetPersister.NotFoundException {
       CaracteristiquesProduits caract = RepCarac.findById(codecar)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        RepCarac.deleteById(codecar);
        //  logger.info("Product {} is deleted", produit.getIdPROD());


    }



    @Transactional
    @Override
    public void updatecaract(Long codecar, CaracteristiquesProduits car) {
        CaracteristiquesProduits caracToUpdate = RepCarac.findById(codecar).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"caracteristique existe pas dans la base de données")

        );
        if(car.getLibcar()!=null && !car.getLibcar().isEmpty()){

        }
    }


    @Override
    public List<CaracteristiquesProduits> getAllCract() {
        return (List<CaracteristiquesProduits>) RepCarac.findAll();
    }


}

