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
import entites.Transporteur;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.Statics;

/**
 *
 * @author malek
 */
public class ServiceTransporteurs { 
    
   public static ServiceTransporteurs instance = null;
   private ConnectionRequest req;
   public static ServiceTransporteurs getInstance(){
   
   if(instance == null)
       instance = new  ServiceTransporteurs();
    return instance ;
   }
   
   public ServiceTransporteurs(){
   
   req = new ConnectionRequest();
   }
   
   
   
   public void ajouttransporteur(Transporteur Transporteur){
    String url = Statics.BASE_URL+"/AddTransporteur?type="+Transporteur.getType()+"&numero="+Transporteur.getNumero()+"&nom="+Transporteur.getNom()+"&adresse="+Transporteur.getAdresse()+"&mail="+Transporteur.getMail();
        req.setUrl(url);
        req.addResponseListener((e)-> {
           
            String str = new String(req.getResponseData());
            System.out.println("data == "+str);
        
        });
       NetworkManager.getInstance().addToQueueAndWait(req);
        
   
   }
    
    
    
    
}
