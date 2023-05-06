/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author Hass
 */
public class Locaux {
 private int id;
 private String nom;
 private String adresse;
 private String description;
  private String imageName;
  //private imageFile;
  private int note;
   private String googleMap;
   //private int programmes;

    public Locaux() {
    }

    public Locaux(String nom, String adresse, String description, String imageName, int note, String googleMap) {
        this.nom = nom;
        this.adresse = adresse;
        this.description = description;
        this.imageName = imageName;
        this.note = note;
        this.googleMap = googleMap;
    }

    public Locaux(int id, String nom, String adresse, String description, String imageName, int note, String googleMap) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.description = description;
        this.imageName = imageName;
        this.note = note;
        this.googleMap = googleMap;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getGoogleMap() {
        return googleMap;
    }

    public void setGoogleMap(String googleMap) {
        this.googleMap = googleMap;
    }

    @Override
    public String toString() {
        return "Locaux{" + "id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", description=" + description + ", imageName=" + imageName + ", note=" + note + ", googleMap=" + googleMap + '}';
    }
 
  
   
   
   
}
