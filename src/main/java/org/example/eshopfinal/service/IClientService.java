package org.example.eshopfinal.service;

import java.util.List;

import org.example.eshopfinal.entities.Client;
import org.springframework.stereotype.Service;


@Service
public interface IClientService {
    Client Ajouterclient(Client cli);
    void updateclient(Client cli, Long id);
    Client Desactiverclient(Long id);
    List <Client> getAllclient();

}