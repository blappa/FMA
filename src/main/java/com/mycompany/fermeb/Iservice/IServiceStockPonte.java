/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.Iservice;

import com.douwe.generic.dao.DataAccessException;
import com.mycompany.fermeb.entities.StockPonte;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IServiceStockPonte {
    
    public void create(StockPonte s) throws DataAccessException;
     public List findAll() throws DataAccessException;
     public StockPonte findId(Long id) throws DataAccessException;
      public void delete(Long id) throws DataAccessException;
     public void update(StockPonte s) throws DataAccessException;
}
