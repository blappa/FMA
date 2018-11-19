/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.beans;

import com.douwe.generic.dao.DataAccessException;
import com.mycompany.fermeb.Iservice.IServicePersonnel;
import com.mycompany.fermeb.entities.Personnel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
public class initBean implements Serializable {

    @ManagedProperty(value = "#{IServicePersonnel}")
    private IServicePersonnel iserPer;
    private Personnel personnel;
    private Personnel current;
    private List<Personnel> listpersonnel;

    public initBean() {
        personnel = new Personnel();
        current = new Personnel();
    }
    
    public String login(){
        try {
            List<Personnel> cc;
            cc = iserPer.findAll();
            listpersonnel = new ArrayList<Personnel>();
            System.out.println(""+current.getLogin());
            for (Personnel personne : cc) {
                if(personne.getLogin().equals(current.getLogin())){
                    if(personne.getPassword().equals(current.getPassword())){
                       return "admin";
                    }
                }
            }
        } catch (DataAccessException ex) {
            Logger.getLogger(Personnel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    
     public String init(ActionEvent actionEvent) throws DataAccessException {
        listpersonnel = iserPer.findAll();
        Date d =new Date();
        if (listpersonnel.isEmpty()) {
            Personnel p = new Personnel("admin", null, "admin", "admin", null, d, 0, null, 0);
            iserPer.create(p);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Un compte par defaut s'est crée avec: \n\t\t LOGIN : admin \n\t\t MOT DE PASSE: admin", ""));
            return null;
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Un compte existe déja", ""));
            return null;
        }
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

    public List<Personnel> getListpersonnel() {
        return listpersonnel;
    }

    public void setListpersonnel(List<Personnel> listpersonnel) {
        this.listpersonnel = listpersonnel;
    }

    public Personnel getCurrent() {
        return current;
    }

    public void setCurrent(Personnel current) {
        this.current = current;
    }

    
    
}
