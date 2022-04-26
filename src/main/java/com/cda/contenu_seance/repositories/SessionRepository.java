package com.cda.contenu_seance.repositories;

import com.cda.contenu_seance.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository <Session, Long>{
}
