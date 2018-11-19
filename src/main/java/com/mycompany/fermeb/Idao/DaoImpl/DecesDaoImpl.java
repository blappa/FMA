/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.Idao.DaoImpl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.mycompany.fermeb.Idao.IDecesDao;
import com.mycompany.fermeb.entities.Deces;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lappa
 */
public class DecesDaoImpl extends GenericDao<Deces, Long> implements IDecesDao{

    @Override
    public Deces findDecesbyId(Long id) throws DataAccessException {
        try {
            return (Deces)getManager().createNamedQuery("Deces.findById").
                    setParameter("id", id).getSingleResult(); //To change body of generated methods, choose Tools | Templates.
        } catch (DataAccessException ex) {
            Logger.getLogger(DecesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Deces> findAllDeces() throws DataAccessException {
        try {
            return getManager().createNamedQuery("Deces.findAll").getResultList(); //To change body of generated methods, choose Tools | Templates.
        } catch (DataAccessException ex) {
            Logger.getLogger(DecesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
