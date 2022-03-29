package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.model.Activite;
import com.cda.contenu_seance.model.Seance;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CompetenceDTO {
    private Long id;
    private String competenceProfessionel;
    private int numCP;
    private Activite activiter;
    private Set<Seance> seances;
}
