package org.example.eshopfinal.controller;

import lombok.RequiredArgsConstructor;
import org.example.eshopfinal.entities.Marque;
import org.example.eshopfinal.service.impl.MarqueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping ("/api/v1/marque")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class MarqueController {
//logisticien
    @Autowired
    MarqueServiceImpl MarqueService;
    @GetMapping

    public List<Marque> getAllMarques(){
        List<Marque> list=MarqueService.getAllmarque();
        return list;

    }
    @PostMapping("/add")
    public Marque AjouterMarque(@RequestBody Marque m){
        return MarqueService.AjouterMarque(m);
    }
    //@PutMapping("/{id}")
    //public void FlagMarque(@PathVariable Long id)
   // {
       // MarqueService.desactivermarque(id);
    //}

    @PutMapping("update/{id}")
    public void UpdateMarque(@PathVariable Long id, @RequestBody Marque m)
    {
        MarqueService.updatemarque(id,m);
    };

   @DeleteMapping("delete/{id}")
    public void   supprimerMarque( @PathVariable Long idm) throws ChangeSetPersister.NotFoundException {
       MarqueService.supprimerMarque(idm);
   }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Marque> saveMarque(@RequestParam("file") MultipartFile file,
                                             @RequestParam("name") String name) throws IOException {
        Marque marque = new Marque();
        marque.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        marque.setLibm(name);
        MarqueService.AjouterMarque(marque);
        return new ResponseEntity<>(marque, HttpStatus.CREATED);
    }

}

