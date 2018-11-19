/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.entities;

import java.io.Serializable;
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

/**
 *
 * @author lappa
 */
@Entity
@Table(name = "StockPonte")
@NamedQueries({
    @NamedQuery(name = "StockPonte.findAll", query = "SELECT s FROM StockPonte s"),
    @NamedQuery(name = "StockPonte.findById", query = "SELECT s FROM StockPonte s WHERE s.id = :id"),
    @NamedQuery(name = "StockPonte.findByQuantite", query = "SELECT s FROM StockPonte s WHERE s.quantite = :quantite")})
public class StockPonte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int quantite;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Poule poule ;

    public StockPonte(int quantite, Poule poule) {
        this.quantite = quantite;
        this.poule = poule;
    }

    public StockPonte(int quantite) {
        this.quantite = quantite;
    }

    public StockPonte() {
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
        if (!(object instanceof StockPonte)) {
            return false;
        }
        StockPonte other = (StockPonte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.fermeb.entities.StockPonte[ id=" + id + " ]";
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Poule getPoule() {
        return poule;
    }

    public void setPoule(Poule poule) {
        this.poule = poule;
    }

    public StockPonte(Long id) {
        this.id = id;
    }

    public StockPonte(Long id, int quantite) {
        this.id = id;
        this.quantite = quantite;
    }

   

}
