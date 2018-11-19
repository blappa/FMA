/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.Idao.DaoImpl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.mycompany.fermeb.Idao.IPouleDao;
import com.mycompany.fermeb.entities.Poule;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lappa
 */
public class PouleDaoImpl extends GenericDao<Poule, Long> implements IPouleDao{

    @Override
    public Poule findPouleById(Long id) throws DataAccessException {
        try {
            return (Poule)getManager().createNamedQuery("Poule.findById").
                    setParameter("id", id).getSingleResult(); //To change body of generated methods, choose Tools | Templates.
        } catch (DataAccessException ex) {
            Logger.getLogger(PouleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Poule findPouleByDateLancement(Date date) throws DataAccessException {
         try {
            return (Poule)getManager().createNamedQuery("Poule.findByDaleLancement").
                    setParameter("date", date).getSingleResult(); //To change body of generated methods, choose Tools | Templates.
        } catch (DataAccessException ex) {
            Logger.getLogger(PouleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Poule findPouleByQuantite(int quantite) throws DataAccessException {
       try {
            return (Poule)getManager().createNamedQuery("Poule.findByQuantite").
                    setParameter("quantite", quantite).getSingleResult(); //To change body of generated methods, choose Tools | Templates.
        } catch (DataAccessException ex) {
            Logger.getLogger(PouleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Poule findPouleByType(String type) throws DataAccessException {
        try {
            return (Poule)getManager().createNamedQuery("Poule.findByType").
                    setParameter("type", type).getSingleResult(); //To change body of generated methods, choose Tools | Templates.
        } catch (DataAccessException ex) {
            Logger.getLogger(PouleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Poule> findAllPoule() throws DataAccessException {
         try {
            return getManager().createNamedQuery("Poule.findAll").getResultList(); //To change body of generated methods, choose Tools | Templates.
        } catch (DataAccessException ex) {
            Logger.getLogger(PouleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


}
