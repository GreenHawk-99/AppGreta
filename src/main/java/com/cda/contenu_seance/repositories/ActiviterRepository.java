package com.cda.contenu_seance.repositories;

import com.cda.contenu_seance.model.Activite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiviterRepository extends JpaRepository <Activite, Long>{
}
