/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.IserviceImpl;

import com.douwe.projet.tutore.exercice.dao.DataAccessException;
import com.mycompany.fermeb.Idao.IHistoPonteDao;
import com.mycompany.fermeb.Iservice.IServiceHistoPonte;
import com.mycompany.fermeb.entities.HistoPonte;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lappa
 */
@Transactional
public class IServiceHistoPonteImpl implements IServiceHistoPonte{
    private IHistoPonteDao histopondao;
    
    
    @Override
     public void create(HistoPonte hip){
        try {
            histopondao.create(hip);
        } catch (com.douwe.generic.dao.DataAccessException ex) {
            Logger.getLogger(IServiceHistoPonteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
     }

      @Override
    public List<HistoPonte> AllHistoPonte() {
        try {
            return histopondao.findAll();
        } catch (com.douwe.generic.dao.DataAccessException ex) {
            Logger.getLogger(IServiceHistoPonteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
      
       @Override
    public void updateHistoPonte(HistoPonte hip) {
        try {
            histopondao.update(hip);
        } catch (com.douwe.generic.dao.DataAccessException ex) {
            Logger.getLogger(IServiceHistoPonteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       }

    @Override
    public void deleteHistoPonte(Long id) {
        try {
            HistoPonte hip=histopondao.findById(id);
            histopondao.delete(hip);
        } catch (com.douwe.generic.dao.DataAccessException ex) {
            Logger.getLogger(IServiceHistoPonteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public IHistoPonteDao getHistopondao() {
        return histopondao;
    }

    public void setHistopondao(IHistoPonteDao histopondao) {
        this.histopondao = histopondao;
    }

    public HistoPonte findById(Long id) throws DataAccessException {
        try {
            return histopondao.findById(id);
        } catch (com.douwe.generic.dao.DataAccessException ex) {
            Logger.getLogger(IServiceHistoPonteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
