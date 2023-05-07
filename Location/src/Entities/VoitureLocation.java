/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author bahar
 */
public class VoitureLocation {
     private int id_voiture;
    private String modele;
    private String matricule ;
    
    private int prix_jour ;
    private String carte_grise ;

    public int getId_voiture() {
        return id_voiture;
    }

    public void setId_voiture(int id_voiture) {
        this.id_voiture = id_voiture;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getCarte_grise() {
        return carte_grise;
    }

    public void setCarte_grise(String carte_grise) {
        this.carte_grise = carte_grise;
    }

    public int getPrix_jour() {
        return prix_jour;
    }

    public void setPrix_jour(int prix_jour) {
        this.prix_jour = prix_jour;
    }

    public VoitureLocation(int id_voiture, String modele, String matricule, int prix_jour, String carte_grise) {
        this.id_voiture = id_voiture;
        this.modele = modele;
        this.matricule = matricule;
        this.prix_jour = prix_jour;
        this.carte_grise = carte_grise;
    }

    public VoitureLocation(String modele, String matricule, int prix_jour, String carte_grise) {
        this.modele = modele;
        this.matricule = matricule;
        this.prix_jour = prix_jour;
        this.carte_grise = carte_grise;
    }

    public VoitureLocation() {
    }

 
  

    @Override
    public String toString() {
        return "VoitureLocation{" + "id_voiture=" + id_voiture + ", modele=" + modele + ", matricule=" + matricule + ", carte_grise=" + carte_grise + ", prix_jour=" + prix_jour + '}';
    }
    
    
    
}
