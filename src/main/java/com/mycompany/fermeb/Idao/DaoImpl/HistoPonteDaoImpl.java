/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.Idao.DaoImpl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.mycompany.fermeb.Idao.IHistoPonteDao;
import com.mycompany.fermeb.entities.HistoPonte;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lappa
 */
public class HistoPonteDaoImpl extends GenericDao<HistoPonte, Long> implements IHistoPonteDao{

    @Override
    public HistoPonte findhistoponteById(Long id) throws DataAccessException {
        try {
            return (HistoPonte)getManager().createNamedQuery("HistoPonte.findById").
                    setParameter("id", id).getSingleResult(); //To change body of generated methods, choose Tools | Templates.
        } catch (DataAccessException ex) {
            Logger.getLogger(HistoAlimentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public HistoPonte findhistoponteByDatePonte(Date date) throws DataAccessException {
        try {
            return (HistoPonte)getManager().createNamedQuery("HistoPonte.findByDatePonte").
                    setParameter("date", date).getSingleResult(); //To change body of generated methods, choose Tools | Templates.
        } catch (DataAccessException ex) {
            Logger.getLogger(HistoAlimentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public HistoPonte findhistoponteByQuantite(int quantite) throws DataAccessException {
       try {
            return (HistoPonte)getManager().createNamedQuery("HistoPonte.findById").
                    setParameter("quantite", quantite).getSingleResult(); //To change body of generated methods, choose Tools | Templates.
        } catch (DataAccessException ex) {
            Logger.getLogger(HistoAlimentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<HistoPonte> findAllhistoponte() throws DataAccessException {
        try {
            return getManager().createNamedQuery("HistoPonte.findById").getResultList(); //To change body of generated methods, choose Tools | Templates.
        } catch (DataAccessException ex) {
            Logger.getLogger(HistoAlimentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
