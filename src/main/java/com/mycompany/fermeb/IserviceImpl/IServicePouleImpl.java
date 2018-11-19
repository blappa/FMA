/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.IserviceImpl;

import com.douwe.generic.dao.DataAccessException;
import com.mycompany.fermeb.Idao.IPouleDao;
import com.mycompany.fermeb.Iservice.IServicePoule;
import com.mycompany.fermeb.entities.Poule;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lappa
 */
@Transactional
public class IServicePouleImpl implements IServicePoule{
     
    private IPouleDao ipouleDao;
    
    @Override
    public void create(Poule p) throws DataAccessException {
        try {
            ipouleDao.create(p); //To change body of generated methods, choose Tools | Templates.
        } catch (DataAccessException ex) {
            Logger.getLogger(IServicePouleImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

       @Override
    public Poule findById(Long id) throws DataAccessException {
        return ipouleDao.findById(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Poule> AllPoules() throws DataAccessException {
       return ipouleDao.findAll();
      //  return null;
    }
    
      @Override
    public void update(Poule p) throws DataAccessException {
       ipouleDao.update(p);
    }

    @Override
    public void delete(Long id) throws DataAccessException {
        Poule p=ipouleDao.findPouleById(id);
       ipouleDao.delete(p);
    }
    
    public IPouleDao getIpouleDao() {
        return ipouleDao;
    }

    public void setIpouleDao(IPouleDao ipouleDao) {
        this.ipouleDao = ipouleDao;
    }

  
}
