/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.entities;

import java.io.Serializable;
import java.util.Date;
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

/**
 *
 * @author lappa
 */
@Entity
@Table(name = "HistoAliment")
@NamedQueries({
    @NamedQuery(name = "HistoAliment.findAll", query = "SELECT h FROM HistoAliment h"),
    @NamedQuery(name = "HistoAliment.findById", query = "SELECT h FROM HistoAliment h WHERE h.id = :id"),
    @NamedQuery(name = "HistoAliment.findByDate", query = "SELECT h FROM HistoAliment h WHERE h.date = :date"),
    @NamedQuery(name = "HistoAliment.findByQuantite", query = "SELECT h FROM HistoAliment h WHERE h.quantite = :quantite")})
public class HistoAliment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int quantite;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn( nullable = false)
    private Poule poule;
   
   
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn( nullable = false)
    private StockAliment stockAliment;

    public HistoAliment(int quantite, Date date, Poule poule, StockAliment stockAliment) {
        this.quantite = quantite;
        this.date = date;
        this.poule = poule;
        this.stockAliment = stockAliment;
    }

    public HistoAliment() {
    }

    public Poule getPoule() {
        return poule;
    }

    public void setPoule(Poule poule) {
        this.poule = poule;
    }

    public StockAliment getStockAliment() {
        return stockAliment;
    }

    public void setStockAliment(StockAliment stockAliment) {
        this.stockAliment = stockAliment;
    }
  
   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
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
        if (!(object instanceof HistoAliment)) {
            return false;
        }
        HistoAliment other = (HistoAliment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.fermeb.entities.HistoAliment[ id=" + id + " ]";
    }
    
}
