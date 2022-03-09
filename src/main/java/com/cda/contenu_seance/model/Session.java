/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/
package com.cda.contenu_seance.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.*;


@Entity
@Getter
@Setter
@NoArgsConstructor

public class Session {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateDebut;
    private Date dateFin;

    @ManyToOne
    private Centre centre;
    @ManyToOne
    private Formation formation;
    @OneToMany(mappedBy = "session")
    private List<Seance> seances;
    @ManyToMany
    private List<Formateur> formateurs;
    @ManyToOne
    private Coordinateur coordinateur;


    public Session(Date dateDebut, Date dateFin, Centre centre, Formation formation, List<Seance> seances, List<Formateur> formateurs) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.centre = centre;
        this.formation = formation;
        this.seances = seances;
        this.formateurs = formateurs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Session session = (Session) o;
        return id != null && Objects.equals(id, session.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}