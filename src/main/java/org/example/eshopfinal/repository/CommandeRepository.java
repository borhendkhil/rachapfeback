package org.example.eshopfinal.repository;

import org.example.eshopfinal.entities.Commande;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface CommandeRepository extends CrudRepository <Commande, Long> {
    public List<Commande> findCommandeByEtatcmd(String etatCmd);
    public List<Commande>findCommandeByDatecmd(Date dateCmd);

}
