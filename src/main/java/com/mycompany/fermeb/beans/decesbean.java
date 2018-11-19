/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.beans;

import com.douwe.generic.dao.DataAccessException;
import com.mycompany.fermeb.Iservice.IServiceDeces;
import com.mycompany.fermeb.Iservice.IServicePoule;
import com.mycompany.fermeb.entities.Deces;
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
public class decesbean implements Serializable{

    @ManagedProperty(value = "#{IServiceDeces}")
    private IServiceDeces servdeces;
    @ManagedProperty(value = "#{IServicePoule}")
    private IServicePoule servpoule;
    
    private Poule pl;
    private List<Deces> listdeces;
    private Deces deces;
    private Long pouleId;
    private Long decesId;

    public decesbean() {
        pl=new Poule();
        deces=new Deces();
    }

    public String saveDeces(ActionEvent actionEven) throws com.douwe.projet.tutore.exercice.dao.DataAccessException, DataAccessException {
        Poule p=servpoule.findById(pouleId);
        deces.setPoule(p);
        servdeces.create(deces);
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"enregistrement avec succées", ""));  
        return "savedeces";
    }
    
    public String updateDeces(ActionEvent actionEven) throws com.douwe.projet.tutore.exercice.dao.DataAccessException, DataAccessException {
        Deces d=servdeces.findById(deces.getId());
        Poule p=servpoule.findById(pouleId);
        deces.setId(d.getId());
        deces.setPoule(p);
        servdeces.update(deces);
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"mise à jour avec succées", ""));  
        return "savedeces";
    }
    
    public String delete(ActionEvent actionEven) throws com.douwe.projet.tutore.exercice.dao.DataAccessException, DataAccessException {
        Deces d=servdeces.findById(deces.getId());
        servdeces.delete(d.getId());
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"suppression réussit", ""));  
        return "savedeces";
    }

    public IServiceDeces getServdeces() {
        return servdeces;
    }

    public void setServdeces(IServiceDeces servdeces) {
        this.servdeces = servdeces;
    }

    public List<Deces> getListdeces() throws com.douwe.projet.tutore.exercice.dao.DataAccessException {
        listdeces=servdeces.findByAllDeces();
        return listdeces;
    }
    

    public void setListdeces(List<Deces> listdeces) {
        this.listdeces = listdeces;
    }

    public Deces getDeces() {
        return deces;
    }

    public void setDeces(Deces deces) {
        this.deces = deces;
    }

    public Poule getPl() {
        return pl;
    }

    public void setPl(Poule pl) {
        this.pl = pl;
    }

    public Long getPouleId() {
        return pouleId;
    }

    public void setPouleId(Long pouleId) {
        this.pouleId = pouleId;
    }

    public IServicePoule getServpoule() {
        return servpoule;
    }

    public void setServpoule(IServicePoule servpoule) {
        this.servpoule = servpoule;
    }

    public Long getDecesId() {
        return decesId;
    }

    public void setDecesId(Long decesId) {
        this.decesId = decesId;
    }
    
    
}
