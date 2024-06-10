package org.example.eshopfinal.service;

import java.util.List;

import org.example.eshopfinal.entities.Couleur;
import org.springframework.stereotype.Service;



@Service
public interface ICouleurService {
    Couleur ajoutercouleur(Couleur c);
    void desactiver(String CodeCl);
    void updatecouleur(String  CodeCl, Couleur c );
    List <Couleur> getAllcouleur();
    Couleur getbylibcl(String libcl);
    Couleur getbyid(Long id);



}
