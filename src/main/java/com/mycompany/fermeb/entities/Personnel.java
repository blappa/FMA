/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fermeb.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author lappa
 */
@Entity
@Table(name = "Personnel")
@NamedQueries({
    @NamedQuery(name = "Personnel.findAll", query = "SELECT p FROM Personnel p"),
    @NamedQuery(name = "Personnel.findById", query = "SELECT p FROM Personnel p WHERE p.id = :id"),
    @NamedQuery(name = "Personnel.findByLogin", query = "SELECT p FROM Personnel p WHERE p.login = :login"),
    @NamedQuery(name = "Personnel.findByNom", query = "SELECT p FROM Personnel p WHERE p.nom = :nom"),
    @NamedQuery(name = "Personnel.findByPassword", query = "SELECT p FROM Personnel p WHERE p.password = :password"),
    @NamedQuery(name = "Personnel.findByPrenom", query = "SELECT p FROM Personnel p WHERE p.prenom = :prenom"),
    @NamedQuery(name = "Personnel.findBySalaire", query = "SELECT p FROM Personnel p WHERE p.salaire = :salaire"),
    @NamedQuery(name = "Personnel.findBySexe", query = "SELECT p FROM Personnel p WHERE p.sexe = :sexe"),
    @NamedQuery(name = "Personnel.findByStatut", query = "SELECT p FROM Personnel p WHERE p.statut = :statut")})
public class Personnel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private String login;
    private String password;
    private String statut;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_payement;
    private int nombre_jour;
    private String sexe;
    private int salaire;
    @OneToMany(mappedBy = "personnel", cascade = {CascadeType.ALL})
    private Set<Poule> poules = new HashSet<Poule>();

    public Personnel(String nom, String prenom, String login, String password, String statut, Date date_payement, int nombre_jour, String sexe, int salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.statut = statut;
        this.date_payement = date_payement;
        this.nombre_jour = nombre_jour;
        this.sexe = sexe;
        this.salaire = salaire;
    }

    public Personnel() {
    }

   
    @Override
    public String toString() {
        return nom+" "+prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Date getDate_payement() {
        return date_payement;
    }

    public void setDate_payement(Date date_payement) {
        this.date_payement = date_payement;
    }

    public int getNombre_jour() {
        return nombre_jour;
    }

    public void setNombre_jour(int nombre_jour) {
        this.nombre_jour = nombre_jour;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    public void addPoule(Poule poule) {

        poules.add(poule);

        poule.setPersonnel(this);
    }

    public Personnel(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Poule> getPoules() {
        return poules;
    }

    public void setPoules(Set<Poule> poules) {
        this.poules = poules;
    }

  
}
