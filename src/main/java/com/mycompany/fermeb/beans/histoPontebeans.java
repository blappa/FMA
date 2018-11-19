/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.beans;

import com.douwe.projet.tutore.exercice.dao.DataAccessException;
import com.mycompany.fermeb.Iservice.IServiceHistoPonte;
import com.mycompany.fermeb.Iservice.IServicePoule;
import com.mycompany.fermeb.Iservice.IServiceStockPonte;
import com.mycompany.fermeb.entities.HistoPonte;
import com.mycompany.fermeb.entities.Poule;
import java.io.Serializable;
import java.util.List;
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
public class histoPontebeans implements Serializable{

    @ManagedProperty(value = "#{IServicehistoPonte}")
    private IServiceHistoPonte servponte;
    @ManagedProperty(value = "#{IServiceStockPonte}")
    private IServiceStockPonte iserStockPonte;
    @ManagedProperty(value = "#{IServicePoule}")
    private IServicePoule servpoule;
    private Poule pl;
    private HistoPonte h;
    private Long pouleId;
    private Long  histoPonteId;
    List<HistoPonte> lhistoPonte;

    public histoPontebeans() {
         pl=new Poule();
          h=new HistoPonte();
    }
    

    public String saveHistoPonte(ActionEvent actionEven) throws DataAccessException, com.douwe.generic.dao.DataAccessException {
        Poule p = servpoule.findById(pouleId);
        h.setPoule(p);
        servponte.create(h);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"enregistrement avec succées", ""));  
        return "savepoule";
    }
    
    public String updateHistoPonte(ActionEvent actionEven) throws DataAccessException, com.douwe.generic.dao.DataAccessException {
        HistoPonte hi=servponte.findById(h.getId());
        Poule p = servpoule.findById(pouleId);
        h.setId(hi.getId());
        h.setPoule(p);
        servponte.updateHistoPonte(h);
        return "savepoule";
    }
    
    public String delete(ActionEvent actionEven) throws DataAccessException, com.douwe.generic.dao.DataAccessException {
        HistoPonte hi=servponte.findById(h.getId());
        servponte.deleteHistoPonte(hi.getId());
        return "savepoule";
    }

    public List<HistoPonte> getLhistoPonte() throws DataAccessException {
        return servponte.AllHistoPonte();
    }

    public void setLhistoPonte(List<HistoPonte> lhistoPonte) {
        this.lhistoPonte = lhistoPonte;
    }

    public IServiceHistoPonte getServponte() {
        return servponte;
    }

    public void setServponte(IServiceHistoPonte servponte) {
        this.servponte = servponte;
    }

    public IServiceStockPonte getIserStockPonte() {
        return iserStockPonte;
    }

    public void setIserStockPonte(IServiceStockPonte iserStockPonte) {
        this.iserStockPonte = iserStockPonte;
    }

    public Poule getPl() {
        return pl;
    }

    public void setPl(Poule pl) {
        this.pl = pl;
    }

    public HistoPonte getH() {
        return h;
    }

    public void setH(HistoPonte h) {
        this.h = h;
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

    public Long getHistoPonteId() {
        return histoPonteId;
    }

    public void setHistoPonteId(Long histoPonteId) {
        this.histoPonteId = histoPonteId;
    }
    
    
}
