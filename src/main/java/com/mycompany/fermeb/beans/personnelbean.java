/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.beans;

import com.douwe.generic.dao.DataAccessException;
import com.mycompany.fermeb.Iservice.IServicePersonnel;
import com.mycompany.fermeb.entities.Personnel;
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
public class personnelbean implements Serializable {

    @ManagedProperty(value = "#{IServicePersonnel}")
    private IServicePersonnel iserPer;
    private Personnel personnel;
    private Long personnelId;
    private List<Personnel> listpersonnel;

    public personnelbean() {
        personnel = new Personnel();
    }

    public String savePersonnel(ActionEvent actionEven) throws DataAccessException {
        iserPer.create(personnel);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "enregistrement avec succées", ""));
        return "savePersonnel";
    }

    public String updatePersonnel(ActionEvent actionEven) throws  DataAccessException {
        Personnel p = iserPer.findById(personnel.getId());
        personnel.setId(p.getId());
        iserPer.update(personnel);
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mise à jour réalisée avec succées", ""));
        return "savePersonnel";
    }

    public String delete(ActionEvent actionEven) throws DataAccessException {
        Personnel p = iserPer.findById(personnel.getId());
        iserPer.delete(p.getId());
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Suppresssion avec succées", ""));
        return "savePersonnel";
    }

    public List<Personnel> getListpersonnel() throws DataAccessException {
        listpersonnel = iserPer.findAll();
        return listpersonnel;
    }

    public void setListpersonnel(List<Personnel> listpersonnel) {
        this.listpersonnel = listpersonnel;
    }

    public IServicePersonnel getIserPer() {
        return iserPer;
    }

    public void setIserPer(IServicePersonnel iserPer) {
        this.iserPer = iserPer;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    public Long getPersonnelId() {
        return personnelId;
    }

    public void setPersonnelId(Long personnelId) {
        this.personnelId = personnelId;
    }
    
    
}
