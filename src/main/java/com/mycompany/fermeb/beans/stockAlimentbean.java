/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.beans;

import com.douwe.projet.tutore.exercice.dao.DataAccessException;
import com.mycompany.fermeb.Iservice.IServiceStockAliment;
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
public class stockAlimentbean implements Serializable{

    @ManagedProperty(value = "#{IServiceStockAliment}")
    private IServiceStockAliment servStockAliment;
    private Poule pl;
    
    private Long stockalimentId;
    private List<StockAliment> listStockAliment;
    private StockAliment stockAliment;

    public stockAlimentbean() {
        pl=new Poule();
        stockAliment=new StockAliment();
    }

    public void saveStockAliment(ActionEvent actionEven) throws DataAccessException{
    servStockAliment.create(stockAliment);
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"enregistrement avec succées", ""));
    }
    
     public void updateStockAliment(ActionEvent actionEven) throws DataAccessException{
    StockAliment s=servStockAliment.findById(stockAliment.getId());
    stockAliment.setId(s.getId());
    servStockAliment.update(stockAliment);
    }
     
     public void delete(ActionEvent actionEven) throws DataAccessException{
     StockAliment s=servStockAliment.findById(stockAliment.getId());
    servStockAliment.delete(s.getId());
    }
    
     public String warning() throws com.douwe.projet.tutore.exercice.dao.DataAccessException{
         listStockAliment=servStockAliment.findAll();
        for (StockAliment s : listStockAliment) {
            if(s.getQuantite()<=5)
                return "menuWarning";
        }
        return null;
        
    }

    public IServiceStockAliment getServStockAliment() {
        return servStockAliment;
    }

    public void setServStockAliment(IServiceStockAliment servStockAliment) {
        this.servStockAliment = servStockAliment;
    }

    public Poule getPl() {
        return pl;
    }

    public void setPl(Poule pl) {
        this.pl = pl;
    }

    public List<StockAliment> getListStockAliment() throws DataAccessException {
        listStockAliment=servStockAliment.findAll();
        return listStockAliment;
    }

    public void setListStockAliment(List<StockAliment> listStockAliment) {
        this.listStockAliment = listStockAliment;
    }

    public StockAliment getStockAliment() {
        return stockAliment;
    }

    public void setStockAliment(StockAliment stockAliment) {
        this.stockAliment = stockAliment;
    }

    public Long getStockalimentId() {
        return stockalimentId;
    }

    public void setStockalimentId(Long stockalimentId) {
        this.stockalimentId = stockalimentId;
    }
     
   
}
