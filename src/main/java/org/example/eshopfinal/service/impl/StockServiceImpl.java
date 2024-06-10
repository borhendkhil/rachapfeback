package org.example.eshopfinal.service.impl;

import java.util.List;

import org.example.eshopfinal.entities.Stock;
import jakarta.transaction.Transactional;
import org.example.eshopfinal.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import org.springframework.web.server.ResponseStatusException;
import org.example.eshopfinal.repository.StockRepository;

@Service
public class StockServiceImpl implements IStockService {
    @Autowired
    StockRepository RepStock;

    @Override
    public Stock Ajouterstock(Stock s)
    {
        RepStock.save(s);
        return s;
    }

    @Override
    public void flagstock(Long idstck) {
        Stock stockToFlag = RepStock.findById(idstck).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"stock existe pas dans la bd")

        );
        stockToFlag.setFlag(true);
    }


    @Override
    public List<Stock> getallstock() {
        return (List<Stock>) RepStock.findAll();
    }

    @Override
    @Transactional
    public void updatestock(Long idstck, Stock s) {
        Stock stockToUpdate = RepStock.findById(idstck).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Stock existe pas dans la base de données")
        );
        if(s.getQte() != null ){
            stockToUpdate.setQte(s.getQte());
        }


        if(s.getEmplacement()!= null && !s.getEmplacement().isEmpty()){
            stockToUpdate.setEmplacement(s.getEmplacement());
        }


    }
}

