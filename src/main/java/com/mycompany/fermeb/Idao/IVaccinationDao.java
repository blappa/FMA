/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.Idao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.mycompany.fermeb.entities.Vaccination;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IVaccinationDao extends IDao<Vaccination, Long> {

    public Vaccination findVaccinationById(Long id) throws DataAccessException;

    public Vaccination findVaccinationBydatevaccination(Date date_vac) throws DataAccessException;

    public Vaccination findVaccinationByNom(String nom) throws DataAccessException;

    public Vaccination findVaccinationByPeriode(String periode) throws DataAccessException;
    
    public List<Vaccination> findAllVaccination() throws DataAccessException;
}
