package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.model.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class SessionDTO {
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDebut;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateFin;

    private Centre centre;
    private Formation formation;
    private List<Seance> seances;
    private List<Formateur> formateurs;
    private Coordinateur coordinateur;
}
