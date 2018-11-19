/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author lappa
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "StockAliment.findAll", query = "SELECT s FROM StockAliment s"),
    @NamedQuery(name = "StockAliment.findById", query = "SELECT s FROM StockAliment s WHERE s.id = :id"),
    @NamedQuery(name = "StockAliment.findByQuantite", query = "SELECT s FROM StockAliment s WHERE s.quantite = :quantite"),
    @NamedQuery(name = "StockAliment.findByType", query = "SELECT s FROM StockAliment s WHERE s.type = :type")})
public class StockAliment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private int quantite;
    @OneToMany(mappedBy = "stockAliment", cascade = {CascadeType.ALL})
    private Set<HistoAliment> histoAliments;

    public StockAliment() {
    }

    
    public StockAliment(String type, int quantite) {
        this.histoAliments = new HashSet<HistoAliment>();
        this.type = type;
        this.quantite = quantite;
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
        if (!(object instanceof StockAliment)) {
            return false;
        }
        StockAliment other = (StockAliment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.fermeb.entities.StockAliment[ id=" + id + " ]";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void addHistoAliment(HistoAliment histoAliment) {

        histoAliments.add(histoAliment);

        histoAliment.setStockAliment(this);
    }
   
}
