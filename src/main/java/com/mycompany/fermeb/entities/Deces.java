/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author lappa
 */
@Entity
@Table(name = "Deces")
@NamedQueries({
    @NamedQuery(name = "Deces.findAll", query = "SELECT d FROM Deces d"),
    @NamedQuery(name = "Deces.findById", query = "SELECT d FROM Deces d WHERE d.id = :id"),
    @NamedQuery(name = "Deces.findByDateDeces", query = "SELECT d FROM Deces d WHERE d.dateDeces = :dateDeces"),
    @NamedQuery(name = "Deces.findByQuantite", query = "SELECT d FROM Deces d WHERE d.quantite = :quantite")})
public class Deces implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDeces;
    private int quantite;
    private String motif;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Poule poule;

    public Deces() {
    }

    public Deces(Date dateDeces, int quantite, String Motif, Poule poule) {
        this.dateDeces = dateDeces;
        this.quantite = quantite;
        this.motif = Motif;
        this.poule = poule;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
   
    public Date getDateDeces() {
        return dateDeces;
    }

    public void setDateDeces(Date dateDeces) {
        this.dateDeces = dateDeces;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

   
    public Poule getPoule() {
        return poule;
    }

    public void setPoule(Poule poule) {
        this.poule = poule;
    }

    public Deces(Long id) {
        this.id = id;
    }

    public Deces(Long id, int quantite) {
        this.id = id;
        this.quantite = quantite;
    }

   
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deces)) {
            return false;
        }
        Deces other = (Deces) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.fermeb.entities.Deces[ id=" + id + " ]";
    }
}
