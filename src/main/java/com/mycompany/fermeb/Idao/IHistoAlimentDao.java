/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.Idao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.mycompany.fermeb.entities.HistoAliment;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IHistoAlimentDao extends IDao<HistoAliment, Long> {

    public HistoAliment findhistoAlimentById(Long id) throws DataAccessException;

    public HistoAliment findhistoAlimentByDate(Date date) throws DataAccessException;

    public HistoAliment findhistoAlimentByQuantite(int quantite) throws DataAccessException;

    public List<HistoAliment> findAllhistoAliment() throws DataAccessException;
}
