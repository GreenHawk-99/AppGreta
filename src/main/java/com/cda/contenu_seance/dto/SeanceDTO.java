package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.model.Competence;
import com.cda.contenu_seance.model.Formateur;
import com.cda.contenu_seance.model.Session;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class SeanceDTO {
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDuJour;
    @NotNull
    @NotBlank
    private int duree;
    @NotNull
    @NotEmpty
    private String objectifPeda;
    @NotNull
    @NotEmpty
    private String support;
    @NotNull
    @NotEmpty
    private String deroulement;

    private Formateur formateur;
    private Session session;
    private Competence competence;
}
