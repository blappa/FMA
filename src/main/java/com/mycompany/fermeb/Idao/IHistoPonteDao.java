/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.Idao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.mycompany.fermeb.entities.HistoPonte;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IHistoPonteDao extends IDao<HistoPonte, Long> {

    public HistoPonte findhistoponteById(Long id) throws DataAccessException;

    public HistoPonte findhistoponteByDatePonte(Date date) throws DataAccessException;

    public HistoPonte findhistoponteByQuantite(int quantite) throws DataAccessException;

    public List<HistoPonte> findAllhistoponte() throws DataAccessException;
}
