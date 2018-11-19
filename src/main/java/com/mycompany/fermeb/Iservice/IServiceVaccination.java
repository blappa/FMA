/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.Iservice;

import com.douwe.generic.dao.DataAccessException;
import com.mycompany.fermeb.entities.Vaccination;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IServiceVaccination {

    public void create(Vaccination v) throws DataAccessException;

    public List<Vaccination> findAll() throws DataAccessException;
   public Vaccination findById(Long id) throws DataAccessException;
    public void update(Vaccination v) throws DataAccessException;
    public void delete(Long id) throws DataAccessException;
}
