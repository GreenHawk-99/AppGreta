package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.models.entities.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class SessionDTO {
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateDebut;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateFin;
    @NotNull(message = "Le champ ne doit pas être null")
    private int dureeTotal;

    private Centre centre;
    private Formation formation;
    private List<Seance> seances;
    private List<Formateur> formateurs;
    private Coordinateur coordinateur;
}
