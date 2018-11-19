/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.Iservice;

import com.douwe.projet.tutore.exercice.dao.DataAccessException;
import com.mycompany.fermeb.entities.HistoPonte;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IServiceHistoPonte {

    public void create(HistoPonte hip) throws DataAccessException;

    public List<HistoPonte> AllHistoPonte() throws DataAccessException;
    
     public HistoPonte findById(Long id) throws DataAccessException;

    public void updateHistoPonte(HistoPonte hip) throws DataAccessException;

    public void deleteHistoPonte(Long id) throws DataAccessException;
}
