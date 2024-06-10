package org.example.eshopfinal.controller;

import lombok.RequiredArgsConstructor;
import org.example.eshopfinal.decorators.ActiveRole;
import org.example.eshopfinal.entities.Client;
import org.example.eshopfinal.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("client")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ClientController {
@Autowired
    ClientServiceImpl clientService;

@GetMapping
public List<Client> GetAllClient(){
        List<Client> list=clientService.getAllclient();
        return list;


//vendeur
    }
    @PostMapping("/add")
    public Client AjouterClient(@RequestBody Client cli){
        return clientService.Ajouterclient(cli);
    }

    @PutMapping("/{id}")
    public  void DesactiverClient(@PathVariable Long id){
        clientService.Desactiverclient(id);

    }
    @PutMapping("update/{id}")
    public void UpdateClient(@RequestBody Client cli,@PathVariable Long id){

        clientService.updateclient(cli,id);
    }


}

