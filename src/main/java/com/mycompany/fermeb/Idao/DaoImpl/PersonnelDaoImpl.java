/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.Idao.DaoImpl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.mycompany.fermeb.Idao.IPersonnelDao;
import com.mycompany.fermeb.entities.Personnel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lappa
 */
public class PersonnelDaoImpl extends GenericDao<Personnel, Long> implements IPersonnelDao{

    @Override
    public Personnel findPersonnelById(Long id) throws DataAccessException {
         try {
            return (Personnel)getManager().createNamedQuery("Personnel.findById").
                    setParameter("id", id).getSingleResult(); //To change body of generated methods, choose Tools | Templates.
        } catch (DataAccessException ex) {
            Logger.getLogger(PersonnelDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Personnel findPersonnelByLogin(String login) throws DataAccessException {
         try {
            return (Personnel)getManager().createNamedQuery("Personnel.findByLogin").
                    setParameter("login", login).getSingleResult(); //To change body of generated methods, choose Tools | Templates.
        } catch (DataAccessException ex) {
            Logger.getLogger(PersonnelDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Personnel findPersonnelByNom(String nom) throws DataAccessException {
       try {
            return (Personnel)getManager().createNamedQuery("Personnel.findByNom").
                    setParameter("nom", nom).getSingleResult(); //To change body of generated methods, choose Tools | Templates.
        } catch (DataAccessException ex) {
            Logger.getLogger(PersonnelDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Personnel findPersonnelByNbreJour(int nbjour) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Personnel findPersonnelBySexe(String sexe) throws DataAccessException {
       try {
            return (Personnel)getManager().createNamedQuery("Personnel.findBySexe").
                    setParameter("sexe", sexe).getSingleResult(); //To change body of generated methods, choose Tools | Templates.
        } catch (DataAccessException ex) {
            Logger.getLogger(PersonnelDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Personnel findPersonnelByStatut(String statut) throws DataAccessException {
        try {
            return (Personnel)getManager().createNamedQuery("Personnel.findByStatut").
                    setParameter("statut", statut).getSingleResult(); //To change body of generated methods, choose Tools | Templates.
        } catch (DataAccessException ex) {
            Logger.getLogger(PersonnelDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Personnel> findAllPersonnel() throws DataAccessException {
        try {
            return getManager().createNamedQuery("Personnel.findAll").getResultList();
        } catch (DataAccessException ex) {
            Logger.getLogger(PersonnelDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
