/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.IserviceImpl;

import com.douwe.generic.dao.DataAccessException;
import com.mycompany.fermeb.Idao.IPersonnelDao;
import com.mycompany.fermeb.Iservice.IServicePersonnel;
import com.mycompany.fermeb.entities.Personnel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lappa
 */
@Transactional
public class IServicePersonnelImpl implements IServicePersonnel {

    private IPersonnelDao ipersDao;

    @Override
    public void create(Personnel p) {
        try {
            ipersDao.create(p); //To change body of generated methods, choose Tools | Templates.
        } catch (DataAccessException ex) {
            Logger.getLogger(IServicePersonnelImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Personnel> findAll() throws DataAccessException {
        return ipersDao.findAll();
    }
    
     @Override
    public void update(Personnel p) throws DataAccessException {
       ipersDao.update(p);
     }

    @Override
    public void delete(Long id) throws DataAccessException {
        Personnel p=ipersDao.findById(id);
        ipersDao.delete(p);
    }
    
    @Override
    public Personnel findById(Long id) throws DataAccessException {
        return ipersDao.findById(id);
    }

    public IPersonnelDao getIpersDao() {
        return ipersDao;
    }

    public void setIpersDao(IPersonnelDao ipersDao) {
        this.ipersDao = ipersDao;
    }
}
