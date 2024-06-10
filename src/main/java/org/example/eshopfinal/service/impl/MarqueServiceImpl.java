package org.example.eshopfinal.service.impl;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.example.eshopfinal.entities.Marque;
import jakarta.transaction.Transactional;
import org.example.eshopfinal.service.IMarqueService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.springframework.web.server.ResponseStatusException;
import org.example.eshopfinal.repository.MarqueRepository;

@Service
@RequiredArgsConstructor
public class MarqueServiceImpl implements IMarqueService {

    private final MarqueRepository RepMarque;
    @Override
    public Marque AjouterMarque(Marque m) {
        RepMarque.save(m);
        return m;
    }

    @Transactional
    @Override
    public void supprimerMarque(Long idm) throws ChangeSetPersister.NotFoundException {
        Marque marque = RepMarque.findById(idm)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        RepMarque.deleteById(idm);
    }
        @Override
        public void updatemarque(Long idm, Marque m) {
        Marque marqueToUpdate = RepMarque.findById(idm).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"marque existe pas dans la base de données")
        );
        if(m.getLibm()!= null && !m.getLibm().isEmpty()){
            marqueToUpdate.setLibm(m.getLibm());

        }
        if(m.getDescription()!=null && !m.getDescription().isEmpty()){
            marqueToUpdate.setDescription(m.getDescription());
        }




    }

    @Override
    public List<Marque> getAllmarque() {

        return (List<Marque>) RepMarque.findAll();
    }
}