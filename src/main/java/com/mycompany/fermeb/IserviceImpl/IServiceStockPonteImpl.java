/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.IserviceImpl;

import com.douwe.generic.dao.DataAccessException;
import com.mycompany.fermeb.Idao.IStockPonteDao;
import com.mycompany.fermeb.Iservice.IServiceStockPonte;
import com.mycompany.fermeb.entities.StockPonte;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lappa
 */
@Transactional
public class IServiceStockPonteImpl implements IServiceStockPonte {

    private IStockPonteDao iserStockPonteDao;

    @Override
    public void create(StockPonte s) throws DataAccessException {
        iserStockPonteDao.create(s); //To change body of generated methods, choose Tools | Templates.
    }

    public IStockPonteDao getIserStockPonteDao() {
        return iserStockPonteDao;
    }

    public void setIserStockPonteDao(IStockPonteDao iserStockPonteDao) {
        this.iserStockPonteDao = iserStockPonteDao;
    }

    @Override
    public List findAll() throws DataAccessException {
        return iserStockPonteDao.findAll();
    }

    public StockPonte findId(Long id) throws DataAccessException {
        return iserStockPonteDao.findById(id);
    }

    public void update(StockPonte s) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(Long id) throws DataAccessException {
        StockPonte s=iserStockPonteDao.findById(id);
        iserStockPonteDao.delete(s);
    }
}
