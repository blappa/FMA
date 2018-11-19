/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.Idao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.mycompany.fermeb.entities.Deces;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IDecesDao extends IDao<Deces, Long>{
    
    public Deces findDecesbyId(Long id) throws DataAccessException;
    
    public List<Deces> findAllDeces() throws DataAccessException;
    
    
    
}
