/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.IserviceImpl;

import com.douwe.projet.tutore.exercice.dao.DataAccessException;
import com.mycompany.fermeb.Idao.IDecesDao;
import com.mycompany.fermeb.Idao.IPouleDao;
import com.mycompany.fermeb.Iservice.IServiceDeces;
import com.mycompany.fermeb.entities.Deces;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lappa
 */
@Transactional
public class IServiceDecesImpl implements IServiceDeces{
    private IDecesDao idecesdao;
    private IPouleDao ipouldao;

    @Override
    public void create(Deces d)  throws DataAccessException{
        try {       
            idecesdao.create(d); //To change body of generated methods, choose Tools | Templates.
        } catch (com.douwe.generic.dao.DataAccessException ex) {
            Logger.getLogger(IServiceDecesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Deces findById(Long id) {
        try {
          return idecesdao.findById(id); //To change body of generated methods, choose Tools | Templates.
        } catch (com.douwe.generic.dao.DataAccessException ex) {
            Logger.getLogger(IServiceDecesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Deces> findByAllDeces()  {
        try {       
           return idecesdao.findAll(); //To change body of generated methods, choose Tools | Templates.
        } catch (com.douwe.generic.dao.DataAccessException ex) {
            Logger.getLogger(IServiceDecesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return null;
    }
    
      @Override
    public void update(Deces d) {
        try {
            idecesdao.update(d); //To change body of generated methods, choose Tools | Templates.
        } catch (com.douwe.generic.dao.DataAccessException ex) {
            Logger.getLogger(IServiceDecesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
    public IDecesDao getIdecesdao() {
        return idecesdao;
    }

    public void setIdecesdao(IDecesDao idecesdao) {
        this.idecesdao = idecesdao;
    }

    public IPouleDao getIpouldao() {
        return ipouldao;
    }

    public void setIpouldao(IPouleDao ipouldao) {
        this.ipouldao = ipouldao;
    }

    public void delete(Long id) throws DataAccessException {
        try {
            Deces d=idecesdao.findById(id);
            idecesdao.delete(d);
        } catch (com.douwe.generic.dao.DataAccessException ex) {
            Logger.getLogger(IServiceDecesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
