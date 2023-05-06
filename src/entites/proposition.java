/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.util.Date;


/**
 *
 * @author Firqs
 */
public class proposition {
    private int id;
    private String nom;
    private Date date;
    private int nombre_place;
    private String email;
    private String mail;

    public proposition() {
    }

    public proposition(int id, String nom, Date date, int nombre_place, String email, String mail) {
        this.id = id;
        this.nom = nom;
        this.date = date;
        this.nombre_place = nombre_place;
        this.email = email;
        this.mail = mail;
    }

    public proposition(String nom, int nombre_place, String mail) {
        this.nom = nom;
        this.nombre_place = nombre_place;
        this.mail = mail;
    }
public proposition(String nom,Date date, int nombre_place, String mail) {
        this.nom = nom;
        this.date = date;
        this.nombre_place = nombre_place;
        this.mail = mail;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNombre_place() {
        return nombre_place;
    }

    public void setNombre_place(int nombre_place) {
        this.nombre_place = nombre_place;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "proposition{" + "id=" + id + ", nom=" + nom + ", date=" + date + ", nombre_place=" + nombre_place + ", email=" + email + ", mail=" + mail + '}';
    }
    
    
    
    
}
