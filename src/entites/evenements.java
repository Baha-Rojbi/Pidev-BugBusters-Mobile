/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.util.Date;


/**
 *
 * 
 */
public class evenements {
    private int id;
    private String nom;
    private Date date;
    private String image_name;
    private int nbrplace;
    private Date datef;
    private String lieu;
    private String description;
    private double rating;
    
      public evenements() {
    }

    public evenements(int id, String nom, Date date, String image_name, int nbrplace, Date datef, String lieu, String description) {
        this.id = id;
        this.nom = nom;
        this.date = date;
        this.image_name = image_name;
        this.nbrplace = nbrplace;
        this.datef = datef;
        this.lieu = lieu;
        this.description = description;
    }

    public evenements(int id, double rating) {
        this.id = id;
        this.rating = rating;
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

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    public int getNbrplace() {
        return nbrplace;
    }

    public void setNbrplace(int nbrplace) {
        this.nbrplace = nbrplace;
    }

    public Date getDatef() {
        return datef;
    }

    public void setDatef(Date datef) {
        this.datef = datef;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

   

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "evenements{" + "id=" + id + ", nom=" + nom + ", date=" + date + ", image_name=" + image_name + ", nbrplace=" + nbrplace + ", datef=" + datef + ", lieu=" + lieu + ", description=" + description + ", rating=" + rating + '}';
    }
    
    

    

    
      
      
}
