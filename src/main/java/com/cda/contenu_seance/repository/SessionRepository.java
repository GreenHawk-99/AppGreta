package com.cda.contenu_seance.repository;

import com.cda.contenu_seance.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository <Session, Long>{
}