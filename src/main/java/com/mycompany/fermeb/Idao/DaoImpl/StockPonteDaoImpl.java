/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.Idao.DaoImpl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.mycompany.fermeb.Idao.IStockPonteDao;
import com.mycompany.fermeb.entities.StockPonte;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lappa
 */
public class StockPonteDaoImpl extends GenericDao<StockPonte, Long> implements IStockPonteDao{

    @Override
    public StockPonte findStockPonteById(Long id) throws DataAccessException {
        try {
            return (StockPonte)getManager().createNamedQuery("StockPonte.findById").
                    setParameter("id", id).getSingleResult();
        } catch (DataAccessException ex) {
            Logger.getLogger(StockPonteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public StockPonte findStockPonteByQuantite(int quantite) throws DataAccessException {
      try {
            return (StockPonte)getManager().createNamedQuery("StockPonte.findByQuantite").
                    setParameter("quantite", quantite).getSingleResult();
        } catch (DataAccessException ex) {
            Logger.getLogger(StockPonteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<StockPonte> findAllStockPonte() throws DataAccessException {
        try {
            return getManager().createNamedQuery("StockPonte.findAll").getResultList();
        } catch (DataAccessException ex) {
            Logger.getLogger(StockPonteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
