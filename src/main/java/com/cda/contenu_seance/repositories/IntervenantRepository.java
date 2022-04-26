package com.cda.contenu_seance.repositories;

import com.cda.contenu_seance.models.Intervenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntervenantRepository extends JpaRepository<Intervenant,Long> {
}
