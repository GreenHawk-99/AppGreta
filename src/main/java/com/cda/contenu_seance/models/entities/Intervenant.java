package com.cda.contenu_seance.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.DiscriminatorType.STRING;

@Entity
@Getter
@Setter
@NoArgsConstructor
/*
L'annotation @Inheritance permet de choisir le type d'heritage que la classe va effectuer dans la database
Le type ici présent est single table ce qui signifie que une classe apparaitra dans la base de données avec colonne nommée TYPE
qui possèdera les discriminants correspondant aux classes via l'annotation @DiscriminatorColumn
 */
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", discriminatorType=STRING)
public abstract class Intervenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String mdp;
    private String codePostal;
    private String tel;
}
