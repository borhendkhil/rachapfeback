package org.example.eshopfinal.repository;

import org.example.eshopfinal.entities.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StockRepository extends CrudRepository<Stock,Long> {

}