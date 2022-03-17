package com.cda.contenu_seance.repository;

import com.cda.contenu_seance.model.Intervenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntervenantRepository extends JpaRepository<Intervenant,Long> {
}
