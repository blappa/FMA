/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.beans;

import com.douwe.generic.dao.DataAccessException;
import com.mycompany.fermeb.Iservice.IServicePoule;
import com.mycompany.fermeb.Iservice.IServiceStockPonte;
import com.mycompany.fermeb.entities.Poule;
import com.mycompany.fermeb.entities.StockPonte;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author lappa
 */
@ManagedBean
@RequestScoped
public class stockPontebean implements Serializable{

    @ManagedProperty(value = "#{IServiceStockPonte}")
    private IServiceStockPonte iserStockPonte;
    @ManagedProperty(value = "#{IServicePoule}")
    private IServicePoule servpoule;
    
    private StockPonte stockPonte;
    private List<StockPonte> liststockPonte;
    
    private Long stockPonteId;
    private Long pouleId;

    public stockPontebean() {
        stockPonte=new StockPonte();
    }

    public String saveStockPonte(ActionEvent actionEven) {
        try {
            Poule p=servpoule.findById(pouleId);
            stockPonte.setPoule(p);
            iserStockPonte.create(stockPonte);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"enregistrement avec succées", ""));
        } catch (DataAccessException ex) {
            Logger.getLogger(stockPontebean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "saveStockPonte";
    }

    public String updateStockPonte(ActionEvent actionEven) {
        try {
            Poule p=servpoule.findById(pouleId);
            StockPonte s=iserStockPonte.findId(stockPonte.getId());
            stockPonte.setId(s.getId());
            stockPonte.setId(p.getId());
            iserStockPonte.update(stockPonte);
        } catch (DataAccessException ex) {
            Logger.getLogger(stockPontebean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "saveStockPonte";
    }

     public String delete(ActionEvent actionEven) {
        try {
            StockPonte s=iserStockPonte.findId(stockPonte.getId());
            iserStockPonte.delete(s.getId());
        } catch (DataAccessException ex) {
            Logger.getLogger(stockPontebean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "saveStockPonte";
    }
    
    public IServiceStockPonte getIserStockPonte() {
        return iserStockPonte;
    }

    public void setIserStockPonte(IServiceStockPonte iserStockPonte) {
        this.iserStockPonte = iserStockPonte;
    }

    public StockPonte getStockPonte() {
        return stockPonte;
    }

    public void setStockPonte(StockPonte stockPonte) {
        this.stockPonte = stockPonte;
    }

    public List<StockPonte> getListstockPonte() throws DataAccessException {
         liststockPonte=iserStockPonte.findAll();
        return liststockPonte;
    }

    public void setListstockPonte(List<StockPonte> liststockPonte) {
        this.liststockPonte = liststockPonte;
    }

    public Long getStockPonteId() {
        return stockPonteId;
    }

    public void setStockPonteId(Long stockPonteId) {
        this.stockPonteId = stockPonteId;
    }

    public IServicePoule getServpoule() {
        return servpoule;
    }

    public void setServpoule(IServicePoule servpoule) {
        this.servpoule = servpoule;
    }

    public Long getPouleId() {
        return pouleId;
    }

    public void setPouleId(Long pouleId) {
        this.pouleId = pouleId;
    }

    
}
