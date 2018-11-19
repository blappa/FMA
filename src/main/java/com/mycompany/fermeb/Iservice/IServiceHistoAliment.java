/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.Iservice;

import com.douwe.projet.tutore.exercice.dao.DataAccessException;
import com.mycompany.fermeb.entities.HistoAliment;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IServiceHistoAliment {
    
    public void create(HistoAliment hi) throws DataAccessException;
    
    public HistoAliment findById(Long id) throws DataAccessException;
     public List <HistoAliment> findAll() throws DataAccessException;
    public void delete(Long id) throws DataAccessException;
    public void update(HistoAliment hi) throws DataAccessException;
}
