/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.Iservice;

import com.douwe.projet.tutore.exercice.dao.DataAccessException;
import com.mycompany.fermeb.entities.Deces;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IServiceDeces {
   public void create(Deces d) throws DataAccessException;
    
    public Deces findById(Long id) throws DataAccessException;
    public List<Deces> findByAllDeces() throws DataAccessException;
   // public List<Deces> findByAllDeces() throws DataAccessException;
    public void update(Deces d) throws DataAccessException;
     public void delete(Long id) throws DataAccessException;
}
