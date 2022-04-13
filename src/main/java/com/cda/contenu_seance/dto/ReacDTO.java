package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.model.Activite;
import com.cda.contenu_seance.model.Formation;
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
public class ReacDTO {
    private Long id;
    @NotNull
    @NotEmpty
    private String nom;
    @NotNull
    @NotEmpty
    @NotBlank
    private String lien;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDebut;
    @NotNull
    @NotEmpty
    private int duree;
    private Formation formation;
    private List<Activite> activites;
}
