/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.Idao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.mycompany.fermeb.entities.Personnel;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IPersonnelDao extends IDao<Personnel, Long>{

    
    public Personnel findPersonnelById(Long id) throws DataAccessException;
    public Personnel findPersonnelByLogin(String login) throws DataAccessException;
    public Personnel findPersonnelByNom(String nom) throws DataAccessException;
    public Personnel findPersonnelByNbreJour(int nbjour) throws DataAccessException;
    public Personnel findPersonnelBySexe(String sexe) throws DataAccessException;
    public Personnel findPersonnelByStatut(String statut) throws DataAccessException;
    public List<Personnel> findAllPersonnel() throws DataAccessException;
    
}
