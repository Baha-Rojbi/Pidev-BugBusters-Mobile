/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.util.Date;



/**
 *
 * @author Taher
 */
public class Alerts {
       
    private int id;
    private int programme_id; 
    private String localisation;
    private Date date;
    private String rapport;
    private int telephone;
    private String mail;
                    
    public Alerts(){}

    public Alerts(int id, String localisation, Date date, String rapport, int telephone, String mail) 
    {
        this.id = id;
        this.localisation = localisation;
        this.date = date;
        this.rapport = rapport;
        this.telephone = telephone;
        this.mail = mail;
    }
    public Alerts(int id,int programme_id, String localisation, Date date, String rapport, int telephone, String mail) 
    {
        this.id = id;
        this.programme_id = programme_id;
        this.localisation = localisation;
        this.date = date;
        this.rapport = rapport;
        this.telephone = telephone;
        this.mail = mail;
    }

    public Alerts(String localisation,  String rapport, int telephone, String mail) {
        this.localisation = localisation;
        this.rapport = rapport;
        this.telephone = telephone;
        this.mail = mail;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getProgramme_id() {
        return programme_id;
    }

    public void setProgramme_id(int programme_id) {
        this.programme_id = programme_id;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getRapport() {
        return rapport;
    }

    public void setRapport(String rapport) {
        this.rapport = rapport;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Alerts{" + "id=" + id + ", localisation=" + localisation + ", date=" + date + ", rapport=" + rapport + ", telephone=" + telephone + ", mail=" + mail + '}';
    }

    
}