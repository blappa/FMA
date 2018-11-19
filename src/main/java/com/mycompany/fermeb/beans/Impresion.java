/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.beans;

import com.douwe.generic.dao.DataAccessException;
import com.mycompany.fermeb.Iservice.IServiceDeces;
import com.mycompany.fermeb.Iservice.IServiceHistoAliment;
import com.mycompany.fermeb.Iservice.IServiceHistoPonte;
import com.mycompany.fermeb.Iservice.IServicePersonnel;
import com.mycompany.fermeb.Iservice.IServicePoule;
import com.mycompany.fermeb.Iservice.IServiceStockAliment;
import com.mycompany.fermeb.Iservice.IServiceStockPonte;
import com.mycompany.fermeb.Iservice.IServiceVaccination;
import com.mycompany.fermeb.entities.Deces;
import com.mycompany.fermeb.entities.HistoAliment;
import com.mycompany.fermeb.entities.HistoPonte;
import com.mycompany.fermeb.entities.Personnel;
import com.mycompany.fermeb.entities.Poule;
import com.mycompany.fermeb.entities.StockAliment;
import com.mycompany.fermeb.entities.StockPonte;
import com.mycompany.fermeb.entities.Vaccination;
import java.io.File;
import javax.faces.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author lappa
 */
@ManagedBean(name = "print")
@RequestScoped
public class Impresion implements Serializable {

    JasperPrint jasperPrint;
    private ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    public String path = servletContext.getRealPath("") + File.separator + "print";
    @ManagedProperty(value = "#{IServiceDeces}")
    private IServiceDeces serviceDeces;
    @ManagedProperty(value = "#{IServiceHistoAliment}")
    private IServiceHistoAliment serviceHistoAliment;
    @ManagedProperty(value = "#{IServiceHistoPonte}")
    private IServiceHistoPonte serviceHistoPonte;
    @ManagedProperty(value = "#{IServicePersonnel}")
    private IServicePersonnel servicePersonnel;
    @ManagedProperty(value = "#{IServicePoule}")
    private IServicePoule servicePoule;
    @ManagedProperty(value = "#{IServiceStockAliment}")
    private IServiceStockAliment serviceStockAliment;
    @ManagedProperty(value = "#{IServiceStockPonte}")
    private IServiceStockPonte serviceStockPonte;
    @ManagedProperty(value = "#{IServiceVaccination}")
    private IServiceVaccination serviceVaccination;
    private List<Deces> decesList;
    private List<HistoAliment> histoAlimentList;
    private List<HistoPonte> histoPonteList;
    private List<Personnel> personnelList;
    private List<Poule> pouleList;
    private List<StockPonte> stockPonteList;
    private List<StockAliment> stockAlimentList;
    private List<Vaccination> vaccinationList;

    public Impresion() {
    }

    public void pdfPersonnel(ActionEvent actionEven) throws JRException, DataAccessException, IOException {
        personnelList = servicePersonnel.findAll();
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(personnelList);
        jasperPrint = JasperFillManager.fillReport(path + File.separator + "personnel" + File.separator + "rpersonnel.jasper", new HashMap(), beanCollectionDataSource);
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("content-disposition", "attachment; filename=personnel.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void pdfPoule(ActionEvent actionEven) throws JRException, DataAccessException, IOException {
        pouleList = servicePoule.AllPoules();
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(pouleList);
        jasperPrint = JasperFillManager.fillReport(path + File.separator + "poule" + File.separator + "rpoule.jasper", new HashMap(), beanCollectionDataSource);
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("content-disposition", "attachment; filename=poule.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void pdfStockAliment(ActionEvent actionEven) throws JRException, DataAccessException, IOException, com.douwe.projet.tutore.exercice.dao.DataAccessException {
        stockAlimentList = serviceStockAliment.findAll();
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(stockAlimentList);
        jasperPrint = JasperFillManager.fillReport(path + File.separator + "stockAliment" + File.separator + "rstockAliment.jasper", new HashMap(), beanCollectionDataSource);
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("content-disposition", "attachment; filename=stockAlimen.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void pdfStockPonte(ActionEvent actionEven) throws JRException, DataAccessException, IOException {
        stockPonteList = serviceStockPonte.findAll();
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(stockPonteList);
        jasperPrint = JasperFillManager.fillReport(path + File.separator + "stockPonte" + File.separator + "rstockPonte.jasper", new HashMap(), beanCollectionDataSource);
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("content-disposition", "attachment; filename=stockPonte.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void pdfVaccination(ActionEvent actionEven) throws JRException, DataAccessException, IOException {
        vaccinationList = serviceVaccination.findAll();
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(vaccinationList);
        jasperPrint = JasperFillManager.fillReport(path + File.separator + "vaccination" + File.separator + "rvaccination.jasper", new HashMap(), beanCollectionDataSource);
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("content-disposition", "attachment; filename=vaccination.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void pdfHistoAliment(ActionEvent actionEven) throws JRException, DataAccessException, IOException, com.douwe.projet.tutore.exercice.dao.DataAccessException {
        histoAlimentList = serviceHistoAliment.findAll();
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(histoAlimentList);
        jasperPrint = JasperFillManager.fillReport(path + File.separator + "histoAliment" + File.separator + "rhistoAliment.jasper", new HashMap(), beanCollectionDataSource);
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("content-disposition", "attachment; filename=histoAliment.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void pdfHistoPonte(ActionEvent actionEven) throws JRException, DataAccessException, IOException, com.douwe.projet.tutore.exercice.dao.DataAccessException {
        histoPonteList = serviceHistoPonte.AllHistoPonte();
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(histoPonteList);
        jasperPrint = JasperFillManager.fillReport(path + File.separator + "histoPonte" + File.separator + "rhistoPonte.jasper", new HashMap(), beanCollectionDataSource);
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("content-disposition", "attachment; filename= histoPonte.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void pdfDeces(ActionEvent actionEven) throws JRException, DataAccessException, IOException, com.douwe.projet.tutore.exercice.dao.DataAccessException {
        decesList = serviceDeces.findByAllDeces();
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(decesList);
        jasperPrint = JasperFillManager.fillReport(path + File.separator + "deces" + File.separator + "rdeces.jasper", new HashMap(), beanCollectionDataSource);
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("content-disposition", "attachment; filename=deces.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        FacesContext.getCurrentInstance().responseComplete();
    }

    public JasperPrint getJasperPrint() {
        return jasperPrint;
    }

    public void setJasperPrint(JasperPrint jasperPrint) {
        this.jasperPrint = jasperPrint;
    }

    public IServiceDeces getServiceDeces() {
        return serviceDeces;
    }

    public void setServiceDeces(IServiceDeces serviceDeces) {
        this.serviceDeces = serviceDeces;
    }

    public IServiceHistoAliment getServiceHistoAliment() {
        return serviceHistoAliment;
    }

    public void setServiceHistoAliment(IServiceHistoAliment serviceHistoAliment) {
        this.serviceHistoAliment = serviceHistoAliment;
    }

    public IServiceHistoPonte getServiceHistoPonte() {
        return serviceHistoPonte;
    }

    public void setServiceHistoPonte(IServiceHistoPonte serviceHistoPonte) {
        this.serviceHistoPonte = serviceHistoPonte;
    }

    public IServicePersonnel getServicePersonnel() {
        return servicePersonnel;
    }

    public void setServicePersonnel(IServicePersonnel servicePersonnel) {
        this.servicePersonnel = servicePersonnel;
    }

    public IServicePoule getServicePoule() {
        return servicePoule;
    }

    public void setServicePoule(IServicePoule servicePoule) {
        this.servicePoule = servicePoule;
    }

    public IServiceStockAliment getServiceStockAliment() {
        return serviceStockAliment;
    }

    public void setServiceStockAliment(IServiceStockAliment serviceStockAliment) {
        this.serviceStockAliment = serviceStockAliment;
    }

    public IServiceStockPonte getServiceStockPonte() {
        return serviceStockPonte;
    }

    public void setServiceStockPonte(IServiceStockPonte serviceStockPonte) {
        this.serviceStockPonte = serviceStockPonte;
    }

    public IServiceVaccination getServiceVaccination() {
        return serviceVaccination;
    }

    public void setServiceVaccination(IServiceVaccination serviceVaccination) {
        this.serviceVaccination = serviceVaccination;
    }

    public List<Deces> getDecesList() {
        return decesList;
    }

    public void setDecesList(List<Deces> decesList) {
        this.decesList = decesList;
    }

    public List<HistoAliment> getHistoAlimentList() {
        return histoAlimentList;
    }

    public void setHistoAlimentList(List<HistoAliment> histoAlimentList) {
        this.histoAlimentList = histoAlimentList;
    }

    public List<HistoPonte> getHistoPonteList() {
        return histoPonteList;
    }

    public void setHistoPonteList(List<HistoPonte> histoPonteList) {
        this.histoPonteList = histoPonteList;
    }

    public List<Personnel> getPersonnelList() {
        return personnelList;
    }

    public void setPersonnelList(List<Personnel> personnelList) {
        this.personnelList = personnelList;
    }

    public List<Poule> getPouleList() {
        return pouleList;
    }

    public void setPouleList(List<Poule> pouleList) {
        this.pouleList = pouleList;
    }

    public List<StockPonte> getStockPonteList() {
        return stockPonteList;
    }

    public void setStockPonteList(List<StockPonte> stockPonteList) {
        this.stockPonteList = stockPonteList;
    }

    public List<StockAliment> getStockAlimentList() {
        return stockAlimentList;
    }

    public void setStockAlimentList(List<StockAliment> stockAlimentList) {
        this.stockAlimentList = stockAlimentList;
    }

    public List<Vaccination> getVaccinationList() {
        return vaccinationList;
    }

    public void setVaccinationList(List<Vaccination> vaccinationList) {
        this.vaccinationList = vaccinationList;
    }
}
