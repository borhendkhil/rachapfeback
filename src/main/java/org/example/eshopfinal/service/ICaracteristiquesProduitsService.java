package org.example.eshopfinal.service;

import java.util.List;

import org.example.eshopfinal.entities.CaracteristiquesProduits;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;



@Service
public interface ICaracteristiquesProduitsService {
    CaracteristiquesProduits ajoutercaract(CaracteristiquesProduits car);
    void supprimercaract( Long codecar) throws ChangeSetPersister.NotFoundException;
    void updatecaract(Long codecar, CaracteristiquesProduits car);
    List <CaracteristiquesProduits> getAllCract();


}
