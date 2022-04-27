package com.cda.contenu_seance.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue(value = "Coordinateur")
public class Coordinateur extends Intervenant{

    @ManyToMany(mappedBy = "coordinateurs")
    private List<Centre> centres;
    @OneToMany(mappedBy = "coordinateur")
    private List<Session> sessions;
}
