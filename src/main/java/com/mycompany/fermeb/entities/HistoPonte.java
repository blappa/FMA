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
@Table(name = "HistoPonte")
@NamedQueries({
    @NamedQuery(name = "HistoPonte.findAll", query = "SELECT h FROM HistoPonte h"),
    @NamedQuery(name = "HistoPonte.findById", query = "SELECT h FROM HistoPonte h WHERE h.id = :id"),
    @NamedQuery(name = "HistoPonte.findByDatePonte", query = "SELECT h FROM HistoPonte h WHERE h.datePonte = :datePonte"),
    @NamedQuery(name = "HistoPonte.findByQuantite", query = "SELECT h FROM HistoPonte h WHERE h.quantite = :quantite")})
public class HistoPonte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datePonte;
    private int quantite;
    private String typeOperation;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Poule poule;

    public HistoPonte() {
    }

    public HistoPonte(Date datePonte, int quantite, Poule poule) {
        this.datePonte = datePonte;
        this.quantite = quantite;
        this.poule = poule;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatePonte() {
        return datePonte;
    }

    public void setDatePonte(Date datePonte) {
        this.datePonte = datePonte;
    }

    public Poule getPoule() {
        return poule;
    }

    public void setPoule(Poule poule) {
        this.poule = poule;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoPonte)) {
            return false;
        }
        HistoPonte other = (HistoPonte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.fermeb.entities.HistoPonte[ id=" + id + " ]";
    }
}
