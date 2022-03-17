package com.cda.contenu_seance.repository;

import com.cda.contenu_seance.model.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationRepository extends JpaRepository <Formation, Long>{
}