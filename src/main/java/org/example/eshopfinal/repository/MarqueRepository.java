package org.example.eshopfinal.repository;

import org.example.eshopfinal.entities.Marque;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MarqueRepository extends CrudRepository <Marque,Long >{

}

