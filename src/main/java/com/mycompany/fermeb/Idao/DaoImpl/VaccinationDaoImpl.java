/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.Idao.DaoImpl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.mycompany.fermeb.Idao.IVaccinationDao;
import com.mycompany.fermeb.entities.Vaccination;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lappa
 */
public class VaccinationDaoImpl extends GenericDao<Vaccination, Long> implements IVaccinationDao{

    @Override
    public Vaccination findVaccinationById(Long id) throws DataAccessException {
        try {
            return (Vaccination)getManager().createNamedQuery("Vaccination.findById").
                    setParameter("id", id).getSingleResult();
        } catch (DataAccessException ex) {
            Logger.getLogger(VaccinationDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Vaccination findVaccinationBydatevaccination(Date date_vac) throws DataAccessException {
        try {
            return (Vaccination)getManager().createNamedQuery("Vaccination.findByDate_vac").
                    setParameter("date_vac", date_vac).getSingleResult();
        } catch (DataAccessException ex) {
            Logger.getLogger(VaccinationDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Vaccination findVaccinationByNom(String nom) throws DataAccessException {
         try {
            return (Vaccination)getManager().createNamedQuery("Vaccination.findByNom").
                    setParameter("nom", nom).getSingleResult();
        } catch (DataAccessException ex) {
            Logger.getLogger(VaccinationDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Vaccination findVaccinationByPeriode(String periode) throws DataAccessException {
       try {
            return (Vaccination)getManager().createNamedQuery("Vaccination.findByPeriodicite").
                    setParameter("periode", periode).getSingleResult();
        } catch (DataAccessException ex) {
            Logger.getLogger(VaccinationDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Vaccination> findAllVaccination() throws DataAccessException {
       try {
            return getManager().createNamedQuery("Vaccination.findByAll").getResultList();
        } catch (DataAccessException ex) {
            Logger.getLogger(VaccinationDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
