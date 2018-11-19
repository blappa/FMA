/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.IserviceImpl;

import com.douwe.projet.tutore.exercice.dao.DataAccessException;
import com.mycompany.fermeb.Idao.IHistoAlimentDao;
import com.mycompany.fermeb.Idao.IStockAlimentDao;
import com.mycompany.fermeb.Iservice.IServiceHistoAliment;
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
public class IServiceHistoAlimentImpl implements IServiceHistoAliment {

    private IHistoAlimentDao iHistoAlimentDao;
    private IStockAlimentDao istockAlimentDao;
    private int qte;

    @Override
    public void create(HistoAliment hi) throws DataAccessException {
        try {
            StockAliment s = istockAlimentDao.findStockAlimentByType(hi.getStockAliment().getType());
            qte = hi.getQuantite();
            if (qte <= s.getQuantite()) {
                iHistoAlimentDao.create(hi);
                qte = s.getQuantite() - qte;
                s.setQuantite(qte);
                istockAlimentDao.update(s);
               // System.out.println(" reste : " + s.getQuantite());
            }
        } catch (com.douwe.generic.dao.DataAccessException ex) {
            Logger.getLogger(IServiceHistoPonteImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

      @Override
    public HistoAliment findById(Long id) {
        try {
            return iHistoAlimentDao.findById(id); //To change body of generated methods, choose Tools | Templates.
        } catch (com.douwe.generic.dao.DataAccessException ex) {
            Logger.getLogger(IServiceHistoAlimentImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void update(HistoAliment hi) {
        try {
            iHistoAlimentDao.update(hi); //To change body of generated methods, choose Tools | Templates.
        } catch (com.douwe.generic.dao.DataAccessException ex) {
            Logger.getLogger(IServiceHistoAlimentImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<HistoAliment> findAll() {
        try {
            return iHistoAlimentDao.findAll();
        } catch (com.douwe.generic.dao.DataAccessException ex) {
            Logger.getLogger(IServiceHistoAlimentImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public IHistoAlimentDao getiHistoAlimentDao() {
        return iHistoAlimentDao;
    }

    public void setiHistoAlimentDao(IHistoAlimentDao iHistoAlimentDao) {
        this.iHistoAlimentDao = iHistoAlimentDao;
    }

    public IStockAlimentDao getIstockAlimentDao() {
        return istockAlimentDao;
    }

    public void setIstockAlimentDao(IStockAlimentDao istockAlimentDao) {
        this.istockAlimentDao = istockAlimentDao;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public void delete(Long id) throws DataAccessException {
        try {
            HistoAliment hi=iHistoAlimentDao.findById(id);
            iHistoAlimentDao.delete(hi);
        } catch (com.douwe.generic.dao.DataAccessException ex) {
            Logger.getLogger(IServiceHistoAlimentImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
}
