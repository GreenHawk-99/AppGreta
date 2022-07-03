package com.cda.contenu_seance.models.repositories;

import com.cda.contenu_seance.models.entities.Intervenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntervenantRepository extends JpaRepository<Intervenant,Long> {
    public Intervenant findByEmail(String username);
}
