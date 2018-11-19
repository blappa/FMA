/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.Idao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.mycompany.fermeb.entities.StockPonte;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IStockPonteDao extends IDao<StockPonte, Long> {

    public StockPonte findStockPonteById(Long id) throws DataAccessException;

    public StockPonte findStockPonteByQuantite(int quantite) throws  DataAccessException;

    public List<StockPonte> findAllStockPonte() throws DataAccessException;
}
