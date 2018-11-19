/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.beans;

import com.douwe.generic.dao.DataAccessException;
import com.mycompany.fermeb.Iservice.IServicePersonnel;
import com.mycompany.fermeb.Iservice.IServicePoule;
import com.mycompany.fermeb.entities.Personnel;
import com.mycompany.fermeb.entities.Poule;
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
public class poulebean implements Serializable{

    @ManagedProperty(value = "#{IServicePoule}")
    private IServicePoule servpoule;
    @ManagedProperty(value = "#{IServicePersonnel}")
   private IServicePersonnel iserPer;
    private Poule pl;
    private List<Poule> lpoule;
    
    private Long personnelId;
     private Long pouleId;

    public poulebean() {
        pl=new Poule();
    }

    public String savePoule(ActionEvent actionEven) {
        try {
            Personnel p =iserPer.findById(personnelId);
            pl.setPersonnel(p);
            servpoule.create(pl);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"enregistrement avec succées", ""));  
        } catch (DataAccessException ex) {
            Logger.getLogger(poulebean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "savepoule";
    }
    
    public String updatePoule(ActionEvent actionEven) {
        try {
            Personnel p =iserPer.findById(pl.getId());
            pl.setPersonnel(p);
            servpoule.update(pl);
        } catch (DataAccessException ex) {
            Logger.getLogger(poulebean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "savepoule";
    }
    
    public String delete(ActionEvent actionEven) {
        try {
            Poule p =servpoule.findById(pl.getId());
            servpoule.delete(p.getId());
        } catch (DataAccessException ex) {
            Logger.getLogger(poulebean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "savepoule";
    }

    public Long getPersonnelId() {
        return personnelId;
    }

    public void setPersonnelId(Long personnelId) {
        this.personnelId = personnelId;
    }

    
    public List<Poule> getLpoule() throws DataAccessException {
        return servpoule.AllPoules();
    }

    public void setLpoule(List<Poule> lpoule) {
        this.lpoule = lpoule;
    }

    public IServicePoule getServpoule() {
        return servpoule;
    }

    public void setServpoule(IServicePoule servpoule) {
        this.servpoule = servpoule;
    }

    public Poule getPl() {
        return pl;
    }

    public void setPl(Poule pl) {
        this.pl = pl;
    }

    public IServicePersonnel getIserPer() {
        return iserPer;
    }

    public void setIserPer(IServicePersonnel iserPer) {
        this.iserPer = iserPer;
    }

    public Long getPouleId() {
        return pouleId;
    }

    public void setPouleId(Long pouleId) {
        this.pouleId = pouleId;
    }
    
    
}
