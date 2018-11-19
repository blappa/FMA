/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.Idao.DaoImpl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.mycompany.fermeb.Idao.IHistoAlimentDao;
import com.mycompany.fermeb.entities.HistoAliment;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lappa
 */
public class HistoAlimentDaoImpl extends GenericDao<HistoAliment, Long> implements IHistoAlimentDao{

    @Override
    public HistoAliment findhistoAlimentById(Long id) throws DataAccessException {
        try {
            return (HistoAliment)getManager().createNamedQuery("HistoAliment.findById").
                    setParameter("id", id).getSingleResult(); //To change body of generated methods, choose Tools | Templates.
        } catch (DataAccessException ex) {
            Logger.getLogger(HistoAlimentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public HistoAliment findhistoAlimentByDate(Date date) throws DataAccessException {
        try {
            return (HistoAliment)getManager().createNamedQuery("HistoAliment.findByDate").
                    setParameter("date", date).getSingleResult(); //To change body of generated methods, choose Tools | Templates.
        } catch (DataAccessException ex) {
            Logger.getLogger(HistoAlimentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public HistoAliment findhistoAlimentByQuantite(int quantite) throws DataAccessException {
        try {
            return (HistoAliment)getManager().createNamedQuery("HistoAliment.findByQuantite").
                    setParameter("quantite", quantite).getSingleResult(); //To change body of generated methods, choose Tools | Templates.
        } catch (DataAccessException ex) {
            Logger.getLogger(HistoAlimentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<HistoAliment> findAllhistoAliment() throws DataAccessException {
        try {
            return getManager().createNamedQuery("HistoAliment.findAll").getResultList(); //To change body of generated methods, choose Tools | Templates.
        } catch (DataAccessException ex) {
            Logger.getLogger(HistoAlimentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
