package com.cda.contenu_seance.models.repositories;

import com.cda.contenu_seance.models.entities.Activite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiviteRepository extends JpaRepository <Activite, Long>{
}
