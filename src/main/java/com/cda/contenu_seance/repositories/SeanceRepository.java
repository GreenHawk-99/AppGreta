package com.cda.contenu_seance.repositories;

import com.cda.contenu_seance.model.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeanceRepository extends JpaRepository <Seance, Long>{
}
