/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.util.Date;

/**
 *
 * @author dell
 */
public class Livraison {
    private int id;
    private String datelivraison;
    private String adresse;
    private int livreur;
    

    public Livraison(int id, String datelivraison, String adresse, int livreur) {
        this.id = id;
        this.datelivraison = datelivraison;
        this.adresse = adresse;
        this.livreur = livreur;
    }

    public Livraison(int id, String datelivraison, String adresse) {
        this.id = id;
        this.datelivraison = datelivraison;
        this.adresse = adresse;
    }

    public Livraison(String datelivraison, String adresse) {
        this.datelivraison = datelivraison;
        this.adresse = adresse;
    }

    public Livraison() {
    }

    public int getId() {
        return id;
    }

    public String getDatelivraison() {
        return datelivraison;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getLivreur() {
        return livreur;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDatelivraison(String datelivraison) {
        this.datelivraison = datelivraison;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setLivreur(int livreur) {
        this.livreur = livreur;
    }

    @Override
    public String toString() {
        return "Livraison{" + "id=" + id + ", datelivraison=" + datelivraison + ", adresse=" + adresse + ", livreur=" + livreur + '}';
    }
    
    
    
}
