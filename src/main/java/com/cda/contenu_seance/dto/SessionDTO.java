package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.models.entities.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    @NotNull(message = "Le champ ne doit pas être null")
    @NotEmpty(message = "Le champ ne peut pas être vide")
    private int dureeTotal;

    private Centre centre;
    private Formation formation;
    private List<Seance> seances;
    private List<Formateur> formateurs;
    private Coordinateur coordinateur;
}
