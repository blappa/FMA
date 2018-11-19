/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.beans;

import com.douwe.generic.dao.DataAccessException;
import com.mycompany.fermeb.Iservice.IServicePersonnel;
import com.mycompany.fermeb.Iservice.IServicePoule;
import com.mycompany.fermeb.Iservice.IServiceVaccination;
import com.mycompany.fermeb.entities.Poule;
import com.mycompany.fermeb.entities.Vaccination;
import java.io.Serializable;
import java.util.Calendar;
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
public class vaccinationbean implements Serializable{

   @ManagedProperty(value = "#{IServiceVaccination}")
    private IServiceVaccination serviceVaccination;
   @ManagedProperty(value = "#{IServicePoule}")
    private IServicePoule servpoule ;
   @ManagedProperty(value = "#{IServicePersonnel}")
    private IServicePersonnel iserPer;
    private List<Vaccination> listVaccinations;
    private Vaccination vaccination;
    private Long pouleId;
    private Long personnelId;
    private Long vaccinationId;

    public vaccinationbean() {
        vaccination=new Vaccination();
    }

    public void saveVaccination(ActionEvent actionEven) throws DataAccessException {
        Poule p = servpoule.findById(pouleId);
        vaccination.setPoule(p);
        serviceVaccination.create(vaccination);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"enregistrement avec succées", ""));
    }

    public void updateVaccination(ActionEvent actionEven) throws DataAccessException {
        Vaccination  v=serviceVaccination.findById(vaccination.getId());
        Poule p = servpoule.findById(pouleId);
        vaccination.setId(v.getId());
        vaccination.setPoule(p);
        serviceVaccination.update(vaccination);
    }
    
     public void delete(ActionEvent actionEven) throws DataAccessException {
        Vaccination  v=serviceVaccination.findById(vaccination.getId());
        serviceVaccination.delete(v.getId());
    }

    public String warning() throws DataAccessException {
        listVaccinations = serviceVaccination.findAll();
        for (Vaccination v : listVaccinations) {
            if (estProche(v) != 0) {
                return "menuWarning";
            }
        }
        return null;

    }

    public int estProche(Vaccination v) {
        Calendar c = Calendar.getInstance();
        c.setTime(v.getDate_vac());
        c.add(Calendar.DATE, v.getPeriodicite());
        Calendar today = Calendar.getInstance();
        if (today.after(c)) {
            return 2;
        } else {
            today.add(Calendar.DATE, 7);
            if (today.after(c)) {
                return 1;
            }
            return 0;
        }
    }

    public String couleur(Vaccination v) {
        if (estProche(v) == 1) {
            return "couleur1";
        } else if (estProche(v) == 2) {
            return "couleur2";
        }
        return null;
    }

    public IServiceVaccination getServiceVaccination() {
        return serviceVaccination;
    }

    public void setServiceVaccination(IServiceVaccination serviceVaccination) {
        this.serviceVaccination = serviceVaccination;
    }

    public List<Vaccination> getListVaccinations() throws DataAccessException {
        listVaccinations=serviceVaccination.findAll();
        return listVaccinations;
    }

    public void setListVaccinations(List<Vaccination> listVaccinations) {
        this.listVaccinations = listVaccinations;
    }

    public Vaccination getVaccination() {
        return vaccination;
    }

    public void setVaccination(Vaccination vaccination) {
        this.vaccination = vaccination;
    }

    public Long getPouleId() {
        return pouleId;
    }

    public void setPouleId(Long pouleId) {
        this.pouleId = pouleId;
    }

    public Long getPersonnelId() {
        return personnelId;
    }

    public void setPersonnelId(Long personnelId) {
        this.personnelId = personnelId;
    }

    public IServicePoule getServpoule() {
        return servpoule;
    }

    public void setServpoule(IServicePoule servpoule) {
        this.servpoule = servpoule;
    }

    public IServicePersonnel getIserPer() {
        return iserPer;
    }

    public void setIserPer(IServicePersonnel iserPer) {
        this.iserPer = iserPer;
    }

    public Long getVaccinationId() {
        return vaccinationId;
    }

    public void setVaccinationId(Long vaccinationId) {
        this.vaccinationId = vaccinationId;
    }
    
    
}
