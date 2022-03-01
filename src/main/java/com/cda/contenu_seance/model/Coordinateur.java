package com.cda.contenu_seance.model;

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

    @OneToMany(mappedBy = "coordinateur")
    private List<Centre> centres;
}
