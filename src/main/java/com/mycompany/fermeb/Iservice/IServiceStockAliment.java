/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.Iservice;

import com.douwe.projet.tutore.exercice.dao.DataAccessException;
import com.mycompany.fermeb.entities.StockAliment;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IServiceStockAliment {
    
    public void create(StockAliment s) throws DataAccessException;
    public void update(StockAliment s) throws DataAccessException;
    public void delete(Long id) throws DataAccessException;
    public List<StockAliment> findAll() throws DataAccessException;
    public StockAliment findById(Long id) throws DataAccessException;
}
