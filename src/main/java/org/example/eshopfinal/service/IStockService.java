package org.example.eshopfinal.service;

import org.example.eshopfinal.entities.Stock;

import java.util.List;



public interface IStockService {
    Stock Ajouterstock(Stock s);
    void flagstock(Long idstck);
    List <Stock> getallstock();
    void updatestock(Long idstck, Stock s);


}
