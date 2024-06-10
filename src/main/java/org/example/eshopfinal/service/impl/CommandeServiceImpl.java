package org.example.eshopfinal.service.impl;

import java.util.Date;
import java.util.List;

import org.example.eshopfinal.entities.Commande;
import jakarta.transaction.Transactional;
import org.example.eshopfinal.service.ICommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.springframework.web.server.ResponseStatusException;
import org.example.eshopfinal.repository.CommandeRepository;

@Service
public class CommandeServiceImpl implements ICommandeService {
    @Autowired
    CommandeRepository Repcmd;

    @Override
    public List<Commande> getAllcommande()
    {
        return (List<Commande>)Repcmd.findAll();
    }

    @Transactional
    @Override
    public void validercommande(Long idcmd) {
        Commande commandeToFlag = Repcmd.findById(idcmd).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"User existe pas dans la bd")

        );
        commandeToFlag.setFlag(true);
    }
    @Override
    public Commande getCommandeById(Long id) {

        return  Repcmd.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"User existe pas dans la bd")
        );
    }

    @Override
    public List<Commande> getCommandeByEtat(String etatCmd) {
        List<Commande> commandes = Repcmd.findCommandeByEtatcmd(etatCmd);
                return commandes;
    }

    @Override
    public List<Commande> getCommandeByDateCreation(Date datecmd) {
        List<Commande> commandes = Repcmd.findCommandeByDatecmd(datecmd);
          return commandes;

    }


}
