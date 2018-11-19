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
@Table(name = "Vaccination")
@NamedQueries({
    @NamedQuery(name = "Vaccination.findAll", query = "SELECT v FROM Vaccination v"),
    @NamedQuery(name = "Vaccination.findById", query = "SELECT v FROM Vaccination v WHERE v.id = :id"),
    @NamedQuery(name = "Vaccination.findByNom", query = "SELECT v FROM Vaccination v WHERE v.nom = :nom"),
    @NamedQuery(name = "Vaccination.findByDate_vac", query = "SELECT v FROM Vaccination v WHERE v.date_vac = :date_vac"),
    @NamedQuery(name = "Vaccination.findByPeriodicite", query = "SELECT v FROM Vaccination v WHERE v.periodicite = :periodicite")})
public class Vaccination implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_vac;
    private int periodicite;

    public Vaccination(String nom, Date date_vac, int periodicite, Poule poule) {
        this.nom = nom;
        this.date_vac = date_vac;
        this.periodicite = periodicite;
        this.poule = poule;
    }

    public Vaccination() {
    }

    public Long getId() {
        return id;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Poule poule;

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Vaccination)) {
            return false;
        }
        Vaccination other = (Vaccination) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.fermeb.entities.Vaccination[ id=" + id + " ]";
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate_vac() {
        return date_vac;
    }

    public Poule getPoule() {
        return poule;
    }

    public void setPoule(Poule poule) {
        this.poule = poule;
    }

    public void setDate_vac(Date date_vac) {
        this.date_vac = date_vac;
    }

    public int getPeriodicite() {
        return periodicite;
    }

    public void setPeriodicite(int periodicite) {
        this.periodicite = periodicite;
    }

    public Vaccination(Long id) {
        this.id = id;
    }

    public Vaccination(Long id, int periodicite) {
        this.id = id;
        this.periodicite = periodicite;
    }

   
}
