/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.Idao.DaoImpl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.mycompany.fermeb.Idao.IStockAlimentDao;
import com.mycompany.fermeb.entities.StockAliment;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lappa
 */
public class StockAlimentDaoImpl extends GenericDao<StockAliment, Long> implements IStockAlimentDao{

    @Override
    public StockAliment findStockAlimentById(Long id) throws DataAccessException {
        try {
            return (StockAliment)getManager().createNamedQuery("StockAliment.findById").
                    setParameter("id", id).getSingleResult();
        } catch (DataAccessException ex) {
            Logger.getLogger(StockAlimentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public StockAliment findStockAlimentByQuantite(int quantite) throws DataAccessException {
         try {
            return (StockAliment)getManager().createNamedQuery("StockAliment.findByQuantite").
                    setParameter("quantite", quantite).getSingleResult();
        } catch (DataAccessException ex) {
            Logger.getLogger(StockAlimentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public StockAliment findStockAlimentByType(String type) throws DataAccessException {
         try {
            return (StockAliment)getManager().createNamedQuery("StockAliment.findByType").
                    setParameter("type", type).getSingleResult();
        } catch (DataAccessException ex) {
            Logger.getLogger(StockAlimentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<StockAliment> findAllStockAliment() throws DataAccessException {
         try {
            return getManager().createNamedQuery("StockAliment.findAll").getResultList();
        } catch (DataAccessException ex) {
            Logger.getLogger(StockAlimentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
