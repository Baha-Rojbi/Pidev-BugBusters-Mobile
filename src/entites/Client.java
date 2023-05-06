/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;
import java.util.List;
import java.util.Set;

/**
 *
 * @author user
 */
public  class  Client  {
    private int id ;
    private String nom ;
    private String prenom ;
    private int telephone ;
    private String adresse ;
    private String password ;
    private String email ;
    private String image_name;
    private String activation_token ;
    List<Commande> commandes ;

    public Client() {
    }

    public Client(String nom, String prenom, int telephone, String adresse, String password, String email,  String image_name, String activation_token) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.adresse = adresse;
        this.password = password;
        this.email = email;
        this.image_name = image_name;
        this.activation_token = activation_token;
    }

   


    public Client(String nom, String prenom, int telephone, String adresse, String email, String image_name) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.adresse = adresse;
        this.email = email;
        this.image_name = image_name;
    }

  

    public Client(int id, String nom, String prenom, int telephone, String adresse, String email, String image_name) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.adresse = adresse;
        this.email = email;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }


     public String RoleToBase(){
return "";
     }

    public String getActivation_token() {
        return activation_token;
    }

    public void setActivation_token(String activation_token) {
        this.activation_token = activation_token;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone + ", adresse=" + adresse + ", password=" + password + ", email=" + email + ", image_name=" + image_name + ", commandes=" + commandes + '}';
    }

}
