/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;

import com.codename1.ui.events.ActionListener;
import entites.produits;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.Statics;

/**
 *
 * @author malek
 */
public class ProduitsService { 
    
   public static ProduitsService instance = null;
   private ConnectionRequest req;
   public static ProduitsService getInstance(){
   
   if(instance == null)
       instance = new  ProduitsService();
    return instance ;
   }
   
   public ProduitsService(){
   
   req = new ConnectionRequest();
   }
   
   
   public ArrayList<produits>affichproduits(){
   ArrayList<produits> result = new ArrayList<>();
   String url = Statics.BASE_URL+"/Showproduit";
   req.setUrl(url);
   req.addResponseListener(new ActionListener<NetworkEvent>() {
       @Override
       public void actionPerformed(NetworkEvent evt) {
           JSONParser jsonp;
           jsonp = new JSONParser();
           try {
             Map<String,Object>mapoffre = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
           
             List<Map<String,Object>> listOfMaps = (List<Map<String,Object>>) mapoffre.get("root");
             for (Map<String,Object> obj : listOfMaps)
             {
               produits of = new produits(); 
                    float id = Float.parseFloat(obj.get("id").toString());
               String nom_produit = obj.get("nom").toString();
               String description_produit = obj.get("description").toString();
               String image_name = obj.get("imageName").toString();
               float prix_produit = Float.parseFloat(obj.get("prix").toString());

               of.setId_produit((int) id);
               of.setNom_produit(nom_produit);
               of.setDescription_produit(description_produit);
               of.setImage_name(image_name);
               of.setPrix_produit((double)prix_produit);

               result.add(of);
               
             }
           }catch (Exception ex){
           ex.printStackTrace();
           }
       }
   });
   NetworkManager.getInstance().addToQueueAndWait(req);
     return  result;
   }

    public produits afficherprod(int id) {
System.out.println(id);
   String url = Statics.BASE_URL+"/ShowproduitS?id="+id;
   req.setUrl(url);
         produits  of = new produits(); 
   req.addResponseListener(new ActionListener<NetworkEvent>() {
       @Override
       public void actionPerformed(NetworkEvent evt) {
           JSONParser jsonp;
           jsonp = new JSONParser();
        
           try {
             Map<String,Object>mapoffre = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
     float id = Float.parseFloat(mapoffre.get("id").toString());
               String nom_produit = mapoffre.get("nom").toString();
               String description_produit = mapoffre.get("description").toString();
               String image_name = mapoffre.get("imageName").toString();
               float prix_produit = Float.parseFloat(mapoffre.get("prix").toString());

               of.setNom_produit(nom_produit);
               of.setDescription_produit(description_produit);
               of.setImage_name(image_name);
               of.setPrix_produit((double)prix_produit);
               of.setId_produit((int) id);
   
           }catch (Exception ex){
           ex.printStackTrace();
           }
       }
   });
   NetworkManager.getInstance().addToQueueAndWait(req);
     return  of; 
    }
    
    
    
    
}
