/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.Idao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.mycompany.fermeb.entities.Poule;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IPouleDao extends IDao<Poule, Long> {

    public Poule findPouleById(Long id) throws DataAccessException;

    public Poule findPouleByDateLancement(Date date) throws DataAccessException;

    public Poule findPouleByQuantite(int quantite) throws DataAccessException;

    public Poule findPouleByType(String type) throws DataAccessException;

    public List<Poule> findAllPoule() throws DataAccessException;
}
