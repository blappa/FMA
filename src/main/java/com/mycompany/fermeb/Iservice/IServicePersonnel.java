/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.Iservice;

import com.douwe.generic.dao.DataAccessException;
import com.mycompany.fermeb.entities.Personnel;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IServicePersonnel {

    public void create(Personnel p) throws DataAccessException;

    public void update(Personnel p) throws DataAccessException;

    public void delete(Long id) throws DataAccessException;

    public List<Personnel> findAll() throws DataAccessException;

    public Personnel findById(Long id) throws DataAccessException;
}
