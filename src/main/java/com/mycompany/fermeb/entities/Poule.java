/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
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
@Table(name = "Poule")
@NamedQueries({
    @NamedQuery(name = "Poule.findAll", query = "SELECT p FROM Poule p"),
    @NamedQuery(name = "Poule.findById", query = "SELECT p FROM Poule p WHERE p.id = :id"),
    @NamedQuery(name = "Poule.findByDaleLancement", query = "SELECT p FROM Poule p WHERE p.daleLancement = :daleLancement"),
    @NamedQuery(name = "Poule.findByDebutPonte", query = "SELECT p FROM Poule p WHERE p.debutPonte = :debutPonte"),
    @NamedQuery(name = "Poule.findByQuantite", query = "SELECT p FROM Poule p WHERE p.quantite = :quantite"),
    @NamedQuery(name = "Poule.findByType", query = "SELECT p FROM Poule p WHERE p.type = :type")})
public class Poule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int quantite;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date daleLancement;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date debutPonte;
    private String type;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Personnel personnel;
    @OneToMany(mappedBy = "poule", cascade = {CascadeType.ALL})
    private Set<Vaccination> vaccinations = new HashSet<Vaccination>();
    @OneToMany(mappedBy = "poule", cascade = {CascadeType.ALL})
    private Set<HistoPonte> histoPontes = new HashSet<HistoPonte>();
    @OneToMany(mappedBy = "poule", cascade = {CascadeType.ALL})
    private Set<HistoAliment> histoAliments = new HashSet<HistoAliment>();
    @OneToMany(mappedBy = "poule", cascade = {CascadeType.ALL})
    private Set<Deces> deceses = new HashSet<Deces>();
    @OneToMany(mappedBy = "poule", cascade = {CascadeType.ALL})
    private Set<StockPonte> stockPontes = new HashSet<StockPonte>();
    
    public Poule() {
    }

    public Poule(int quantite, Date daleLancement, Date debutPonte, String type, Personnel personnel) {
        this.quantite = quantite;
        this.daleLancement = daleLancement;
        this.debutPonte = debutPonte;
        this.type = type;
        this.personnel = personnel;
    }

    public Long getId() {
        return id;
    }

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
        if (!(object instanceof Poule)) {
            return false;
        }
        Poule other = (Poule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return type;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Date getDaleLancement() {
        return daleLancement;
    }

    public void setDaleLancement(Date daleLancement) {
        this.daleLancement = daleLancement;
    }

    public Date getDebutPonte() {
        return debutPonte;
    }

    public void setDebutPonte(Date debutPonte) {
        this.debutPonte = debutPonte;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    public void addVaccin(Vaccination vaccination) {

        vaccinations.add(vaccination);

        vaccination.setPoule(this);
    }

    public void addHistoPonte(HistoPonte histoPonte) {

        histoPontes.add(histoPonte);

        histoPonte.setPoule(this);
    }

    public void addHistoAliment(HistoAliment histoAliment) {

        histoAliments.add(histoAliment);

        histoAliment.setPoule(this);
    }

    public void addDeces(Deces deces) {

        deceses.add(deces);

        deces.setPoule(this);
    }

    public Set<Vaccination> getVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(Set<Vaccination> vaccinations) {
        this.vaccinations = vaccinations;
    }

    public Set<HistoPonte> getHistoPontes() {
        return histoPontes;
    }

    public void setHistoPontes(Set<HistoPonte> histoPontes) {
        this.histoPontes = histoPontes;
    }

    public Set<HistoAliment> getHistoAliments() {
        return histoAliments;
    }

    public void setHistoAliments(Set<HistoAliment> histoAliments) {
        this.histoAliments = histoAliments;
    }

    public Set<Deces> getDeceses() {
        return deceses;
    }

    public void setDeceses(Set<Deces> deceses) {
        this.deceses = deceses;
    }

    public Set<StockPonte> getStockPontes() {
        return stockPontes;
    }

    public void setStockPontes(Set<StockPonte> stockPontes) {
        this.stockPontes = stockPontes;
    }

    public Poule(Long id) {
        this.id = id;
    }

    
    
    
}
