package org.example.eshopfinal.service;

import org.example.eshopfinal.entities.DetailCarecteristique;


import java.util.List;

public interface IDetailCarecteristique {

        public void addDetailCarecteristique(DetailCarecteristique detailCarecteristique);
        public void updateDetailCarecteristique(Long id, DetailCarecteristique detailCarecteristique);
        public void deleteDetailCarecteristique( Long id, DetailCarecteristique detailCarecteristique);
        public List<DetailCarecteristique> getDetailCarecteristique();

}
