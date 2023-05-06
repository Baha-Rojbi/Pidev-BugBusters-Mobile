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

import entites.sponsors;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.Statics;

/**
 *
 *
 */
public class SponsorServices { 
    
   public static SponsorServices instance = null;
   private ConnectionRequest req;
   public static SponsorServices getInstance(){
   
   if(instance == null)
       instance = new  SponsorServices();
    return instance ;
   }
   
   public SponsorServices(){
   
   req = new ConnectionRequest();
   }
   
   
   public ArrayList<sponsors>affichSponsors(){
   ArrayList<sponsors> result = new ArrayList<>();
   String url = Statics.BASE_URL+"/ShowSponsor";
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
               sponsors of = new sponsors(); 
                    float id = Float.parseFloat(obj.get("id").toString());
               String nom = obj.get("nom").toString();
               String adresse = obj.get("adresse").toString();
               String mail = obj.get("mail").toString();
               float numero = Float.parseFloat(obj.get("numero").toString());
                //int numero = Integer.parseInt(obj.get("numero").toString());
               String image_name = obj.get("imageName").toString();
             
             

               of.setId((int) id);
               of.setNom(nom);
               of.setAdresse(adresse);
               of.setMail(mail);
               of.setNumero((int)numero);
               of.setImage_name(image_name);
             

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

    public sponsors afficherspon(int id) {
System.out.println(id);
   String url = Statics.BASE_URL+"/ShowsponsorS?id="+id;
   req.setUrl(url);
         sponsors  of = new sponsors(); 
   req.addResponseListener(new ActionListener<NetworkEvent>() {
       @Override
       public void actionPerformed(NetworkEvent evt) {
           JSONParser jsonp;
           jsonp = new JSONParser();
        
           try {
             Map<String,Object>mapoffre = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
     float id = Float.parseFloat(mapoffre.get("id").toString());
               String nom = mapoffre.get("nom").toString();
               String adresse = mapoffre.get("adresse").toString();
               String mail = mapoffre.get("mail").toString();
                 float numero = Float.parseFloat(mapoffre.get("numero").toString());
            //int numero = Integer.parseInt(mapoffre.get("numero").toString());
               String image_name = mapoffre.get("imageName").toString();
               

               of.setId((int) id);
               of.setNom(nom);
               of.setAdresse(adresse);
               of.setMail(mail);
               of.setNumero((int)numero);
               of.setImage_name(image_name);
   
           }catch (Exception ex){
           ex.printStackTrace();
           }
       }
   });
   NetworkManager.getInstance().addToQueueAndWait(req);
     return  of; 
    }
    
    
    
    
}
