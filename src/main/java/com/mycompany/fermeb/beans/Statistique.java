/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.beans;

import com.douwe.projet.tutore.exercice.dao.DataAccessException;
import com.mycompany.fermeb.Iservice.IServiceDeces;
import com.mycompany.fermeb.entities.Deces;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author lappa
 */
@ManagedBean(name = "stat")
@RequestScoped
public class Statistique implements Serializable {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
    private IServiceDeces servdeces = (IServiceDeces) ctx.getBean("IServiceDeces");
//    
    private CartesianChartModel linearModel;
    private List<Deces> listdeces;

    public Statistique() {
      createLinearModel();
    }

      public CartesianChartModel getLinearModel() {
        return linearModel;
    }
    
    private void createLinearModel() {
        linearModel = new CartesianChartModel(); 
         LineChartSeries series1 = new LineChartSeries();
        try {
            listdeces=servdeces.findByAllDeces();
        } catch (DataAccessException ex) {
            Logger.getLogger(Statistique.class.getName()).log(Level.SEVERE, null, ex);
        }
        String li[] = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        String mois[] = {"Janv", "Fevr", "Mars", "Avril", "Mai", "Jun", "Juillet", "Aout", "Sep", "Oct", "Nov", "Dec"};
        series1.setLabel("Pondeuses");
        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Poulets de chair");
        series2.setMarkerStyle("diamond");
        
       for (Deces d : listdeces) {
            SimpleDateFormat tmp = new SimpleDateFormat("dd/MM/yyyy");
            String s = tmp.format(d.getDateDeces());
            String tm = s.substring(3, 5);
            for (int i = 0; i < li.length; i++) {
                if (li[i] == null ? tm == null : li[i].equals(tm)) {
                    if(d.getPoule().getType().equals("Pondeuse")){
                    series1.set(mois[i], d.getQuantite());
                    }
                    else series2.set(mois[i], d.getQuantite());
                }
            }
        }
  
        linearModel.addSeries(series1);   
        linearModel.addSeries(series2);
    }  

    public IServiceDeces getServdeces() {
        return servdeces;
    }

    public void setServdeces(IServiceDeces servdeces) {
        this.servdeces = servdeces;
    }

    public List<Deces> getListdeces() {
        return listdeces;
    }

    public void setListdeces(List<Deces> listdeces) {
        this.listdeces = listdeces;
    }
    
    
}
