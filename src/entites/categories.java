/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author USER
 */
public class categories {
    private int id_categorie;
    private String nom_categorie;
    private String description_categorie;
    private String image_name;
  
    public categories(){}
    
    public categories(int id_categorie, String nom_categorie, String description_categorie,String image_name) {
        this.id_categorie = id_categorie;
        this.nom_categorie = nom_categorie;
        this.description_categorie=description_categorie;
        this.image_name =image_name;
    }

    
    
    public categories(String nom_categorie, String description_categorie, String image_name) 
    {
        this.id_categorie = id_categorie;
        this.nom_categorie = nom_categorie;
        this.description_categorie=description_categorie;
        this.image_name =image_name ;
    }
    /**
     * @return the id_categorie
     */
    public int getId_categorie() {
        return id_categorie;
    }

        /**
     * @param id_categorie the id_categorie to set
     */
    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }
    
    /**
     * @return the nom_categorie
     */
    public String getNom_categorie() {
        return nom_categorie;
    }

    /**
     * @param nom_categorie the nom_categorie to set
     */
    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }

    
    /**
     * @return the description_categorie
     */
    public String getDescription_categorie() {
        return description_categorie;
    }

    /**
     * @param description_categorie the description_categorie to set
     */
    public void setDescription_categorie(String description_categorie) {
        this.description_categorie = description_categorie;
    }

    
    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }
    
}
