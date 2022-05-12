package com.cda.contenu_seance.models.repositories;

import com.cda.contenu_seance.models.entities.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeanceRepository extends JpaRepository <Seance, Long>{

    @Query(value = "SELECT * FROM SEANCE WHERE LENGTH(DEROULEMENT)<1 OR LENGTH(OBJECTIF_PEDA)<1 OR LENGTH(METHODE_ENVISAGE)<1 OR LENGTH(SUPPORT)<1 ORDER BY DATE_DU_JOUR", nativeQuery = true)
    List<Seance> seanceEmptyDOMSOrderByDate();
}
