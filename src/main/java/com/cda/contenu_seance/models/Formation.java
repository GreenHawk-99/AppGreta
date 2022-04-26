package com.cda.contenu_seance.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Formation {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeFormation;

    @OneToMany(mappedBy = "formation")
    private List<Reac> reac;

    @OneToMany(mappedBy = "formation")
    private List<Session> sessions;
}