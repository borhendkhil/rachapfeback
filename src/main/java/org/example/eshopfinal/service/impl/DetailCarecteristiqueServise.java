package org.example.eshopfinal.service.impl;

import org.example.eshopfinal.entities.DetailCarecteristique;
import org.example.eshopfinal.repository.DetailCarecteristiqueRepository;
import org.example.eshopfinal.service.IDetailCarecteristique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailCarecteristiqueServise implements IDetailCarecteristique {

  @Autowired
  private DetailCarecteristiqueRepository detailCarecteristiqueRepository;


    @Override
    public void addDetailCarecteristique(DetailCarecteristique detailCarecteristique) {
        detailCarecteristiqueRepository.save(detailCarecteristique);

    }

    @Override
    public void updateDetailCarecteristique(Long id, DetailCarecteristique detailCarecteristique) {

        detailCarecteristiqueRepository.save(detailCarecteristique);

    }

    @Override
    public void deleteDetailCarecteristique(Long id, DetailCarecteristique detailCarecteristique) {

            detailCarecteristiqueRepository.delete(detailCarecteristique);

    }

    @Override
    public List<DetailCarecteristique> getDetailCarecteristique() {
        List<DetailCarecteristique> alldetail = detailCarecteristiqueRepository.findAll();
        return alldetail;



    }


}
