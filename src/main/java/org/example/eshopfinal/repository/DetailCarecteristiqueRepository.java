package org.example.eshopfinal.repository;

import org.example.eshopfinal.entities.DetailCarecteristique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailCarecteristiqueRepository extends JpaRepository<DetailCarecteristique, Long> {
}
