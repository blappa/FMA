/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.IserviceImpl;

import com.douwe.projet.tutore.exercice.dao.DataAccessException;
import com.mycompany.fermeb.Idao.IStockAlimentDao;
import com.mycompany.fermeb.Iservice.IServiceStockAliment;
import com.mycompany.fermeb.entities.HistoAliment;
import com.mycompany.fermeb.entities.StockAliment;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lappa
 */
@Transactional
public class IServiceStockAlimentImpl implements IServiceStockAliment{

    private IStockAlimentDao iserStockAlimentDao;
     
    @Override
    public void create(StockAliment s) throws DataAccessException {
        try {
            iserStockAlimentDao.create(s); //To change body of generated methods, choose Tools | Templates.
        } catch (com.douwe.generic.dao.DataAccessException ex) {
            Logger.getLogger(IServiceStockAlimentImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

      @Override
    public StockAliment findById(Long id) throws DataAccessException {
        try {
            return iserStockAlimentDao.findById(id); //To change body of generated methods, choose Tools | Templates.
        } catch (com.douwe.generic.dao.DataAccessException ex) {
            Logger.getLogger(IServiceHistoAlimentImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
      
    public IStockAlimentDao getIserStockAlimentDao() {
        return iserStockAlimentDao;
    }

    public void setIserStockAlimentDao(IStockAlimentDao iserStockAlimentDao) {
        this.iserStockAlimentDao = iserStockAlimentDao;
    }

    @Override
    public List<StockAliment> findAll() throws DataAccessException {
        try {
            return iserStockAlimentDao.findAll();
        } catch (com.douwe.generic.dao.DataAccessException ex) {
            Logger.getLogger(IServiceStockAlimentImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void update(StockAliment s) throws DataAccessException {
        try {
            iserStockAlimentDao.update(s) ;
        } catch (com.douwe.generic.dao.DataAccessException ex) {
            Logger.getLogger(IServiceStockAlimentImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Long id) throws DataAccessException {
        try {
            StockAliment s=iserStockAlimentDao.findById(id);
            iserStockAlimentDao.delete(s);
        } catch (com.douwe.generic.dao.DataAccessException ex) {
            Logger.getLogger(IServiceStockAlimentImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
