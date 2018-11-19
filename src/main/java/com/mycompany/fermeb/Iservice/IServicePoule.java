/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.Iservice;

import com.douwe.generic.dao.DataAccessException;
import com.mycompany.fermeb.entities.Poule;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IServicePoule {
    
    public void create(Poule p) throws DataAccessException;
    public void update(Poule p) throws DataAccessException;
    public void delete(Long id) throws DataAccessException;
    public List<Poule> AllPoules() throws DataAccessException;
    public Poule findById(Long id) throws DataAccessException;
}
