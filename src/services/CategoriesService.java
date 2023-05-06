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
import entites.categories;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.Statics;

/**
 *
 * @author malek
 */
public class CategoriesService { 
    
   public static CategoriesService instance = null;
   private ConnectionRequest req;
   public static CategoriesService getInstance(){
   
   if(instance == null)
       instance = new  CategoriesService();
    return instance ;
   }
   
   public CategoriesService(){
   
   req = new ConnectionRequest();
   }
   
  
   
   public ArrayList<categories>affichcategories(){
   ArrayList<categories> result = new ArrayList<>();
   String url = Statics.BASE_URL+"/Showcategorie";
   req.setUrl(url);
   req.addResponseListener(new ActionListener<NetworkEvent>() {
       @Override
       public void actionPerformed(NetworkEvent evt) {
           JSONParser jsonp;
           jsonp = new JSONParser();
           try {
             Map<String,Object>mapcategorie = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
           
             List<Map<String,Object>> listOfMaps = (List<Map<String,Object>>) mapcategorie.get("root");
             for (Map<String,Object> obj : listOfMaps)
             {
               categories of = new categories(); 
               String nom_categorie = obj.get("nom").toString();
               String description_categorie = obj.get("description").toString();
               String image_name = obj.get("imageName").toString();

               
               of.setNom_categorie(nom_categorie);
               of.setDescription_categorie(description_categorie);
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


    
    
    
    
}
