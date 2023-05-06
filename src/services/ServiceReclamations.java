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
import entites.Reclamations;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.Statics;

/**
 *
 * @author malek
 */
public class ServiceReclamations { 
    
   public static ServiceReclamations instance = null;
   private ConnectionRequest req;
   public static ServiceReclamations getInstance(){
   
   if(instance == null)
       instance = new  ServiceReclamations();
    return instance ;
   }
   
   public ServiceReclamations(){
   
   req = new ConnectionRequest();
   }
   
   
   
   public void ajoutreclamations(Reclamations Reclamations){
    String url = Statics.BASE_URL+"/AddReclamations?type="+Reclamations.getType()+"&description="+Reclamations.getDescription()+"&email="+Reclamations.getEmail();
        req.setUrl(url);
        req.addResponseListener((e)-> {
           
            String str = new String(req.getResponseData());
            System.out.println("data == "+str);
        
        });
       NetworkManager.getInstance().addToQueueAndWait(req);
        
   
   }
    
    
    
    
}
