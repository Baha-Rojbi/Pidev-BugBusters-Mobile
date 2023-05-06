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
import entites.Alerts;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import projet.models.Livreur;
import utils.Statics;

/**
 *
 * @author malek
 */
public class ServiceLivreurs { 
    
   public static ServiceLivreurs instance = null;
   private ConnectionRequest req;
   public static ServiceLivreurs getInstance(){
   
   if(instance == null)
       instance = new  ServiceLivreurs();
    return instance ;
   }
   
   public ServiceLivreurs(){
   
   req = new ConnectionRequest();
   }
   
   
   
   public void ajoutlivreurs(Livreur Livreur){
    String url = Statics.BASE_URL+"/AddLiv?telephone="+Livreur.getTelephone()+"&adresse="+Livreur.getAdresse()+"&mail="+Livreur.getEmail()+"&nom="+Livreur.getNom();
        req.setUrl(url);
        req.addResponseListener((e)-> {
           
            String str = new String(req.getResponseData());
            System.out.println("data == "+str);
        
        });
       NetworkManager.getInstance().addToQueueAndWait(req);
        
   
   }
    

    
}
