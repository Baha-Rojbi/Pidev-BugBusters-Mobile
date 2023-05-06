/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author ASUS
 */
public class Transporteur {
    
    private int id,numero;
    private String type,nom,adresse,mail;
    
    public Transporteur(){
    }

    public Transporteur(int id,  String type, int numero, String nom, String adresse, String mail ) {
        this.id = id;
        this.type = type;
        this.numero = numero;
        this.nom = nom;
        this.adresse = adresse;
        this.mail = mail;
        
    }

    public Transporteur( String type, int numero, String nom, String adresse, String mail) {
        this.type = type;
        this.numero = numero;
        this.nom = nom;
        this.adresse = adresse;
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "Transporteur{" + "id=" + id + ", numero=" + numero + ", type=" + type + ", nom=" + nom + ", adresse=" + adresse + ", mail=" + mail + '}';
    }

  
    
    
    
}
