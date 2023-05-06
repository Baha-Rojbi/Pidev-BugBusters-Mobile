/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.models;

/**
 *
 * @author dell
 */
public class Livreur {
    private int id ;
    private int telephone ;
    private String adresse ;
    private String email ;
    private String nom ;

    public Livreur(int id, int telephone, String adresse, String email, String nom) {
        this.id = id;
        this.telephone = telephone;
        this.adresse = adresse;
        this.email = email;
        this.nom = nom;
    }

    public Livreur(int telephone, String adresse, String email, String nom) {
        this.telephone = telephone;
        this.adresse = adresse;
        this.email = email;
        this.nom = nom;
    }

    public Livreur() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Livreur{" + "id=" + id + ", telephone=" + telephone + ", adresse=" + adresse + ", email=" + email + ", nom=" + nom + '}';
    }
    
}
