package org.example.eshopfinal.repository;

import org.example.eshopfinal.entities.Couleur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CouleurRepository extends CrudRepository<Couleur, String> {
    Couleur findByLibcl(String libcl);
    Couleur findById(Long id);

}
