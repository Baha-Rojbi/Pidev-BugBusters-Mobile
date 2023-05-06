/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entites.produits;
import entites.Client;
import java.util.HashMap;

/**
 *
 * @author user
 */

        public final class UserSession {

    private static UserSession instance;

    private Client client ;
    private HashMap<produits,Integer> panier ;

    public UserSession(Client client) {
        this.client = client;
        this.panier =  new HashMap<produits,Integer>();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

   public void AddLignePanier(produits produit){
       panier.put(produit,1);
   }
     public void RemoveLignePanier(produits produit){
       panier.remove(produit);
   }
     public void SetLignePanier(produits produit,Integer quantite){
       panier.put(produit,quantite);
   }

    public HashMap<produits, Integer> getPanier() {
        return panier;
    }

    public static UserSession getInstace() {
        return instance;
    }
    
    public static void setInstace(Client client) {
            instance = new UserSession(client);
    }
    
  
}
