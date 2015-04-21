/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author js
 */
@Entity
@Table(name="Books")
@NamedQueries(value= {
    @NamedQuery(name="getBook", query="SELECT DISTINCT b.titre FROM Books b"),
    })
public class Books implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String titre;
    private String auteur;
    private int annee;

    public Books(String titre, String auteur, int annee) {
        this.titre = titre;
        this.auteur = auteur;
        this.annee = annee;
    }

    public Books() {
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (titre != null ? titre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the titre fields are not set
        if (!(object instanceof Books)) {
            return false;
        }
        Books other = (Books) object;
        if ((this.titre == null && other.titre != null) || (this.titre != null && !this.titre.equals(other.titre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "titre=" + titre + "\nauteur=" + auteur + "\nparution=" + annee;
    }
    
}
