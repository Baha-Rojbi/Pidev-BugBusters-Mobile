/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.util.Date;

/**
 *
 * @author user
 */
public class Commande  {
    private Integer id ;
    private Date date ;
    private Integer idclient ;
    private Double prix;
    private Livraison livraison ;

    public Commande() {
    }

    public Commande(Date date, Integer idclient,  Double prix) {
        this.date = date;
        this.idclient = idclient;
        this.prix = prix;
    }

    public Commande(Integer id, Date date, Integer idclient, Double prix) {
        this.id = id;
        this.date = date;
        this.idclient = idclient;
        this.prix = prix;
    }

  
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getIdclient() {
        return idclient;
    }

    public void setIdclient(Integer idclient) {
        this.idclient = idclient;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Livraison getLivraison() {
        return livraison;
    }

    public void setLivraison(Livraison livraison) {
        this.livraison = livraison;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", date=" + date + ", idclient=" + idclient + ", prix=" + prix + '}';
    }
    
}
