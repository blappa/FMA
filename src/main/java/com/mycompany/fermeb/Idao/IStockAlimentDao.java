/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.Idao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.mycompany.fermeb.entities.StockAliment;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IStockAlimentDao extends IDao<StockAliment, Long> {

    public StockAliment findStockAlimentById(Long id) throws DataAccessException;

    public StockAliment findStockAlimentByQuantite(int quantite) throws DataAccessException;

    public StockAliment findStockAlimentByType(String type) throws DataAccessException;

    public List<StockAliment> findAllStockAliment() throws DataAccessException;
}
