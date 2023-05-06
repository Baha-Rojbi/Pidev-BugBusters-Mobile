/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * 
 */
public class sponsors {
      private int id;
    private String nom;
    private String adresse;
    private String mail;
    private int numero;
    private String image_name;

    public sponsors() {
    }

    public sponsors(int id, String nom, String adresse, String mail, int numero, String image_name) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.mail = mail;
        this.numero = numero;
        this.image_name = image_name;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    @Override
    public String toString() {
        return "sponsors{" + "id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", mail=" + mail + ", numero=" + numero + ", image_name=" + image_name + '}';
    }
    
    
    
    
    
}
