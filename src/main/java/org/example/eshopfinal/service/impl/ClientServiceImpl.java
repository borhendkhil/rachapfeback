package org.example.eshopfinal.service.impl;

import java.util.List;

import org.example.eshopfinal.entities.Client;
import jakarta.transaction.Transactional;
import org.example.eshopfinal.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.web.server.ResponseStatusException;
import org.example.eshopfinal.repository.ClientRepository;

@Service
public class ClientServiceImpl implements IClientService {
    @Autowired
    ClientRepository Repclient;


    @Override
    public Client Ajouterclient(Client cli) {
        Repclient.save(cli);
        return cli;
    }

    @Transactional
    @Override
    public void updateclient(Client cli, Long id) {
        Client clientToUpdate = Repclient.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"client existe pas dans la base de données")

        );
        if(cli.getCin()!=null ){
            clientToUpdate.setCin(cli.getCin());
        }
        if(cli.getCodepostal()!=null){
            clientToUpdate.setCodepostal(cli.getCodepostal());
        }
        if(cli.getEmail()!=null && !cli.getEmail().isEmpty()){
            clientToUpdate.setEmail(cli.getEmail());
        }
        if (cli.getNom()!= null && !cli.getNom().isEmpty()){
            clientToUpdate.setNom(cli.getNom());
        }
        if(cli.getPrenom()!= null && !cli.getPrenom().isEmpty()){
            clientToUpdate.setPrenom(cli.getPrenom());
        }
        if(cli.getNumtel()!=null){
            clientToUpdate.setNumtel(cli.getNumtel());
        }
        if(cli.getAddresse()!=null && !cli.getAddresse().isEmpty()){
            clientToUpdate.setAddresse(cli.getAddresse());
        }


    }

    @Transactional
    @Override
    public Client Desactiverclient(Long id) {
        Client client = Repclient.findById(id).orElseThrow(() -> new UsernameNotFoundException("client not found"));
        client.setFlag(!client.isFlag());
        return Repclient.save(client);


    }


    @Override
    public List<Client> getAllclient() {
        return (List<Client>) Repclient.findAll();
    }
}

