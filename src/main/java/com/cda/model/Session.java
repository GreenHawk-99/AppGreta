/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/
package com.cda.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.*;


// ----------- << imports@AAAAAAF/IZXd0dtDZOE= >>
// ----------- >>

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Session {
@Id
    private int id_session;
    private Date dateDebut;
    private Date dateFin;

  //  private Formation formation;
    //private Set<Seance> seances = new HashSet<>();

    /*
    public void link(Formation _) {
        if (_ != null) {
            _.get().add(this);
        }

        unlink();
        set(_);
    }

    public void link(Seance seances) {
        if (seances!= null) {
            seances.unlink();
            seances.set(this);
            get().add(seances);
        }
    }

    public void unlink() {
        if (get() != null) {
            get().get().remove(this);
            set(null);
        }
    }

    public void unlink(Seance _) {
        if (_ != null) {
            _.set(null);
            get().remove(_);
        }
    }

    public void unlink(Seance _, Iterator<Seance> it) {
        if (_ != null) {
            _.set(null);
            it.remove();
        }
    }
*/

}