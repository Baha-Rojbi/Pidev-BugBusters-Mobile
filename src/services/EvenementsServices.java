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
import entites.evenements;





import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.Statics;

/**
 *
 * 
 */
public class EvenementsServices { 
    
   public static EvenementsServices instance = null;
   private ConnectionRequest req;
   public static EvenementsServices getInstance(){
   
   if(instance == null)
       instance = new  EvenementsServices();
    return instance ;
   }
   
   public EvenementsServices(){
   
   req = new ConnectionRequest();
   }
   
   
   public ArrayList<evenements>affichevenements(){
   ArrayList<evenements> result = new ArrayList<>();
   String url = Statics.BASE_URL+"/ShowEvent";
   req.setUrl(url);
   req.addResponseListener((NetworkEvent evt) -> {
       JSONParser jsonp;
       jsonp = new JSONParser();
       try {
           Map<String,Object>mapoffre = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
           
           List<Map<String,Object>> listOfMaps = (List<Map<String,Object>>) mapoffre.get("root");
           for (Map<String,Object> obj : listOfMaps)
           {
               evenements of = new evenements();
               float id = Float.parseFloat(obj.get("id").toString());
               String nom = obj.get("nom").toString();
               String image_name = obj.get("imageName").toString();
               
               String lieu = obj.get("Lieu").toString();
               String description = obj.get("description").toString();
               float nbrplace = Float.parseFloat(obj.get("nbrplace").toString());
               //int nbrplace = Integer.parseInt(obj.get("nbrplace").toString());
               
               
               
               of.setId((int) id);
               of.setNom(nom);
               of.setImage_name(image_name);
               of.setNbrplace((int)nbrplace);
               of.setLieu(lieu);
               of.setDescription(description); 
               

               result.add(of);
               
           }
       }catch (Exception ex){
           ex.printStackTrace();
       }
   });
   NetworkManager.getInstance().addToQueueAndWait(req);
     return  result;
   }

    public evenements affichereven(int id) {
System.out.println(id);
   String url = Statics.BASE_URL+"/ShowevenementS?id="+id;
   req.setUrl(url);
         evenements  of = new evenements(); 
   req.addResponseListener(new ActionListener<NetworkEvent>() {
       @Override
       public void actionPerformed(NetworkEvent evt) {
           JSONParser jsonp;
           jsonp = new JSONParser();
        
           try {
             Map<String,Object>mapoffre = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
     float id = Float.parseFloat(mapoffre.get("id").toString());
       
               String nom = mapoffre.get("nom").toString();
               String image_name = mapoffre.get("imageName").toString();
                float nbrplace = Float.parseFloat(mapoffre.get("nbrplace").toString());
                //  int nbrplace = Integer.parseInt(mapoffre.get("nbrplace").toString());
                   String lieu = mapoffre.get("Lieu").toString();
                      String description = mapoffre.get("description").toString();
                 of.setId((int) id);
               of.setNom(nom);
               of.setImage_name(image_name);
               of.setNbrplace((int)nbrplace);
                of.setLieu(lieu);
                of.setDescription(description);
   
           }catch (Exception ex){
           ex.printStackTrace();
           }
       }
   });
   NetworkManager.getInstance().addToQueueAndWait(req);
     return  of; 
    }
    
    
    
    
}
