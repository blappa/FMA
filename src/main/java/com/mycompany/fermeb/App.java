package com.mycompany.fermeb;

import com.douwe.generic.dao.DataAccessException;
import com.mycompany.fermeb.Iservice.IServiceDeces;
import com.mycompany.fermeb.Iservice.IServiceHistoAliment;
import com.mycompany.fermeb.Iservice.IServiceHistoPonte;
import com.mycompany.fermeb.Iservice.IServicePersonnel;
import com.mycompany.fermeb.Iservice.IServicePoule;
import com.mycompany.fermeb.Iservice.IServiceStockAliment;
import com.mycompany.fermeb.Iservice.IServiceStockPonte;
import com.mycompany.fermeb.Iservice.IServiceVaccination;
import com.mycompany.fermeb.entities.HistoAliment;
import com.mycompany.fermeb.entities.HistoPonte;
import com.mycompany.fermeb.entities.Personnel;
import com.mycompany.fermeb.entities.Poule;
import com.mycompany.fermeb.entities.StockAliment;
import java.util.Date;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

    private static IServicePersonnel iserPer;
    private static IServicePoule iserPoule;
    private static IServiceStockPonte iserStockPonte;
    private static IServiceStockAliment iserStockAliment;
    private static IServiceVaccination iServiceVaccination;
    private static IServiceHistoAliment iServiceHistoAliment;
    private static IServiceDeces iServiceDeces;
    private static IServiceHistoPonte iServiceHistoPonte;

    public static void main(String[] args) throws DataAccessException, com.douwe.projet.tutore.exercice.dao.DataAccessException {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");

        iserPer = (IServicePersonnel) ctx.getBean("IServicePersonnel");
        iserPoule = (IServicePoule) ctx.getBean("IServicePoule");
        iserStockPonte = (IServiceStockPonte) ctx.getBean("IServiceStockPonte");
        iserStockAliment = (IServiceStockAliment) ctx.getBean("IServiceStockAliment");
        iServiceVaccination = (IServiceVaccination) ctx.getBean("IServiceVaccination");
        iServiceHistoAliment = (IServiceHistoAliment) ctx.getBean("IServiceHistoAliment");
        iServiceDeces = (IServiceDeces) ctx.getBean("IServiceDeces");
        iServiceHistoPonte = (IServiceHistoPonte) ctx.getBean("IServicehistoPonte");

        Date d = new Date();

//        Personnel p=new Personnel("lappa", "bertrick", "admin", "admin", "", d, 10, "M", 300000);
//        iserPer.create(p);
//        Personnel p=iserPer.findById(1L);
//        Poule pou=new Poule(200, d, d, "pondeuse", p);
//        iserPoule.create(pou);
        Poule pou = iserPoule.findById(1L);
//        StockAliment s=new StockAliment("mais", 50);
//        iserStockAliment.create(s);
        StockAliment s = iserStockAliment.findById(1L);
        
        HistoAliment h = new HistoAliment(21, d, pou, s);
        iServiceHistoAliment.create(h);
    }
}
