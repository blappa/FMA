/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.IserviceImpl;

import com.douwe.generic.dao.DataAccessException;
import com.mycompany.fermeb.Idao.IVaccinationDao;
import com.mycompany.fermeb.Iservice.IServiceVaccination;
import com.mycompany.fermeb.entities.Vaccination;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lappa
 */
@Transactional
public class IServiceVaccinationImpl implements IServiceVaccination{
   
    private IVaccinationDao ivaccDao;
    
    public void create(Vaccination v) throws DataAccessException {
        try {
            ivaccDao.create(v);
             //To change body of generated methods, choose Tools | Templates.
        } catch (DataAccessException ex) {
            Logger.getLogger(IServiceVaccinationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Vaccination v) throws DataAccessException {
        try {
            ivaccDao.update(v);
            //To change body of generated methods, choose Tools | Templates.
        } catch (DataAccessException ex) {
            Logger.getLogger(IServiceVaccinationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public IVaccinationDao getIvaccDao() {
        return ivaccDao;
    }

    public void setIvaccDao(IVaccinationDao ivaccDao) {
        this.ivaccDao = ivaccDao;
    }

    @Override
    public List<Vaccination> findAll() throws DataAccessException {
        try {
            return ivaccDao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(IServiceVaccinationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }

    public void delete(Long id) throws DataAccessException {
        Vaccination v=ivaccDao.findById(id);
        ivaccDao.delete(v);
    }

    public Vaccination findById(Long id) throws DataAccessException {
       return ivaccDao.findById(id);
    }
    
}
