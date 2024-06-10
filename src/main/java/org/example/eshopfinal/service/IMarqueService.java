package org.example.eshopfinal.service;

import java.util.List;

import org.example.eshopfinal.entities.Marque;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;



@Service
public interface IMarqueService {
    Marque AjouterMarque(Marque m);
   void supprimerMarque(Long idm) throws ChangeSetPersister.NotFoundException;
    void updatemarque(Long idm , Marque m);
    List <Marque> getAllmarque();

}
