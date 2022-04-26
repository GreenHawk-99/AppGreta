package com.cda.contenu_seance.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue(value = "Formateur")
public class Formateur extends Intervenant{

    @OneToMany(mappedBy = "formateurs")
    private List<Seance> seances;
    @ManyToMany(mappedBy = "formateurs")
    private List<Session> session;
}