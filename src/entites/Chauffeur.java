/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import java.util.Objects;


/**
 *
 * @author Aziz Bouharb
 */
public class Chauffeur  {

   private int id_client ;
   private String nom_client;
   private String email_client;
   private String pass_client;
   private String image_permis;
   private String matricule_voiture;
   private String permis_chauf;

    public Chauffeur() {
    }

    public Chauffeur(int id_client, String nom_client, String email_client, String pass_client, String image_permis, String matricule_voiture, String permis_chauf) {
        this.id_client = id_client;
        this.nom_client = nom_client;
        this.email_client = email_client;
        this.pass_client = pass_client;
        this.image_permis = image_permis;
        this.matricule_voiture = matricule_voiture;
        this.permis_chauf = permis_chauf;
    }

    public Chauffeur(String nom_client, String email_client, String pass_client, String image_permis, String matricule_voiture, String permis_chauf) {
        this.nom_client = nom_client;
        this.email_client = email_client;
        this.pass_client = pass_client;
        this.image_permis = image_permis;
        this.matricule_voiture = matricule_voiture;
        this.permis_chauf = permis_chauf;
    }

    public Chauffeur(String nom_client, String email_client, String pass_client, String matricule_voiture, String permis_chauf) {
        this.nom_client = nom_client;
        this.email_client = email_client;
        this.pass_client = pass_client;
        this.matricule_voiture = matricule_voiture;
        this.permis_chauf = permis_chauf;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getNom_client() {
        return nom_client;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public String getEmail_client() {
        return email_client;
    }

    public void setEmail_client(String email_client) {
        this.email_client = email_client;
    }

    public String getPass_client() {
        return pass_client;
    }

    public void setPass_client(String pass_client) {
        this.pass_client = pass_client;
    }

    public String getImage_permis() {
        return image_permis;
    }

    public void setImage_permis(String image_permis) {
        this.image_permis = image_permis;
    }

    public String getMatricule_voiture() {
        return matricule_voiture;
    }

    public void setMatricule_voiture(String matricule_voiture) {
        this.matricule_voiture = matricule_voiture;
    }

    public String getPermis_chauf() {
        return permis_chauf;
    }

    public void setPermis_chauf(String permis_chauf) {
        this.permis_chauf = permis_chauf;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Chauffeur other = (Chauffeur) obj;
        if (this.id_client != other.id_client) {
            return false;
        }
        if (!Objects.equals(this.nom_client, other.nom_client)) {
            return false;
        }
        if (!Objects.equals(this.email_client, other.email_client)) {
            return false;
        }
        if (!Objects.equals(this.pass_client, other.pass_client)) {
            return false;
        }
        if (!Objects.equals(this.image_permis, other.image_permis)) {
            return false;
        }
        if (!Objects.equals(this.matricule_voiture, other.matricule_voiture)) {
            return false;
        }
        if (!Objects.equals(this.permis_chauf, other.permis_chauf)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return "Chauffeur{" + "id_client=" + id_client + ", nom_client=" + nom_client + ", email_client=" + email_client + ", pass_client=" + pass_client + ", image_permis=" + image_permis + ", matricule_voiture=" + matricule_voiture + ", permis_chauf=" + permis_chauf + '}';
    }
    
   
}
