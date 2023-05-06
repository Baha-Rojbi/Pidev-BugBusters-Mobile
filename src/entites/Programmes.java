/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.util.Date;

/**
 *
 * @author Hass
 */
public class Programmes {
private int id;
private String nom;
private String date;
private int duree;
private String details;
//private int transporteur;
//private int locale;
//private int participants;
private Locaux loc ;
    public Programmes() {
    }



    public Programmes(int id, String nom, String date, int duree, String details) {
        this.id = id;
        this.nom = nom;
        this.date = date;
        this.duree = duree;
        this.details = details;
    }

    public Programmes(String nom, String date, int duree, String details, Locaux loc) {
        this.nom = nom;
        this.date = date;
        this.duree = duree;
        this.details = details;
        this.loc = loc;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Locaux getLoc() {
        return loc;
    }

    public void setLoc(Locaux loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Programmes{" + "id=" + id + ", nom=" + nom + ", date=" + date + ", duree=" + duree + ", details=" + details + ", loc=" + loc + '}';
    }




    
}
