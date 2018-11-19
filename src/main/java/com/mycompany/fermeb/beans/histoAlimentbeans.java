/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.beans;

import com.douwe.projet.tutore.exercice.dao.DataAccessException;
import com.mycompany.fermeb.Iservice.IServiceHistoAliment;
import com.mycompany.fermeb.Iservice.IServicePoule;
import com.mycompany.fermeb.Iservice.IServiceStockAliment;
import com.mycompany.fermeb.entities.HistoAliment;
import com.mycompany.fermeb.entities.Poule;
import com.mycompany.fermeb.entities.StockAliment;
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
public class histoAlimentbeans implements Serializable{
    
    @ManagedProperty(value = "#{IServiceHistoAliment}")
    private IServiceHistoAliment iServiceHistoAliment;
    @ManagedProperty(value = "#{IServiceStockAliment}")
    private IServiceStockAliment servStockAliment ;
    @ManagedProperty(value = "#{IServicePoule}")
    private IServicePoule servpoule;
    private Poule pl;
    private HistoAliment histoAliment;
    
    private Long stockAlimentId;
    private Long pouleId;
    private Long histoAlimentId;
    
    private  List<HistoAliment> lhistAliments;

    public histoAlimentbeans() {
        histoAliment=new HistoAliment();
        pl=new Poule();
    }
    
    public String saveHistoAliment(ActionEvent actionEven) throws DataAccessException, com.douwe.generic.dao.DataAccessException{
        StockAliment  s=servStockAliment.findById(stockAlimentId);
        Poule p =servpoule.findById(pouleId);
        histoAliment.setStockAliment(s);
        histoAliment.setPoule(p);
         iServiceHistoAliment.create(histoAliment);
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"enregistrement avec succés", ""));  
    return "saveAliment";
    }

     public String updateHistoAliment(ActionEvent actionEven) throws DataAccessException, com.douwe.generic.dao.DataAccessException{
         HistoAliment h=iServiceHistoAliment.findById(histoAliment.getId());
        StockAliment  s=servStockAliment.findById(stockAlimentId);
        Poule p =servpoule.findById(pouleId);
        histoAliment.setId(h.getId());
        histoAliment.setStockAliment(s);
        histoAliment.setPoule(p);
         iServiceHistoAliment.update(histoAliment);
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"mise à jour avec succées", ""));  
    return "saveAliment";
    }
     
      public String delete(ActionEvent actionEven) throws DataAccessException, com.douwe.generic.dao.DataAccessException{
        HistoAliment h=iServiceHistoAliment.findById(histoAliment.getId());
         iServiceHistoAliment.delete(h.getId());
    return "saveAliment";
    }
     
    public IServiceHistoAliment getiServiceHistoAliment() {
        return iServiceHistoAliment;
    }

    public void setiServiceHistoAliment(IServiceHistoAliment iServiceHistoAliment) {
        this.iServiceHistoAliment = iServiceHistoAliment;
    }

    public Poule getPl() {
        return pl;
    }

    public void setPl(Poule pl) {
        this.pl = pl;
    }

    public HistoAliment getHistoAliment() {
        return histoAliment;
    }

    public void setHistoAliment(HistoAliment histoAliment) {
        this.histoAliment = histoAliment;
    }

    public List<HistoAliment> getLhistAliments() throws DataAccessException {
        lhistAliments=iServiceHistoAliment.findAll();
        return lhistAliments;
    }

    public void setLhistAliments(List<HistoAliment> lhistAliments) {
        this.lhistAliments = lhistAliments;
    }

    public Long getStockAlimentId() {
        return stockAlimentId;
    }

    public void setStockAlimentId(Long stockAlimentId) {
        this.stockAlimentId = stockAlimentId;
    }

    public Long getPouleId() {
        return pouleId;
    }

    public void setPouleId(Long pouleId) {
        this.pouleId = pouleId;
    }

    public IServiceStockAliment getServStockAliment() {
        return servStockAliment;
    }

    public void setServStockAliment(IServiceStockAliment servStockAliment) {
        this.servStockAliment = servStockAliment;
    }

    public IServicePoule getServpoule() {
        return servpoule;
    }

    public void setServpoule(IServicePoule servpoule) {
        this.servpoule = servpoule;
    }

    public Long getHistoAlimentId() {
        return histoAlimentId;
    }

    public void setHistoAlimentId(Long histoAlimentId) {
        this.histoAlimentId = histoAlimentId;
    }

  
 
}
