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
public class Reclamations {
    
    private int id;
    private String type,description,email;
    
    public Reclamations(){
    }

    public Reclamations(int id, String type, String description, String email) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.email = email;
    }

    public Reclamations( String type, String description, String email) {
        this.type = type;
        this.description = description;
        this.email = email;    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Reclamations{" + "id=" + id + ", type=" + type + ", description=" + description + ", email=" + email + '}';
    }
    
   
    
    
    
}
