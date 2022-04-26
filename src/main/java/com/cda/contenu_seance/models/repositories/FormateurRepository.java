package com.cda.contenu_seance.models.repositories;

import com.cda.contenu_seance.models.entities.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormateurRepository extends JpaRepository <Formateur, Long>{
}
