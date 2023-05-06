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
import entites.proposition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.Statics;

/**
 *
 * @author malek
 */
public class ServiceProposition { 
    
   public static ServiceProposition instance = null;
   private ConnectionRequest req;
   public static ServiceProposition getInstance(){
   
   if(instance == null)
       instance = new  ServiceProposition();
    return instance ;
   }
   
   public ServiceProposition(){
   
   req = new ConnectionRequest();
   }
   
   
   
   public void ajoutproposition(proposition proposition){
SimpleDateFormat    formatter = new SimpleDateFormat("dd-M-yyyy");  
       String   date = formatter.format(proposition.getDate());
    String url = Statics.BASE_URL+"/Addproposition?nom="+proposition.getNom()+"&date="+date+"&nombre_place="+proposition.getNombre_place()+"&mail="+proposition.getMail();        req.setUrl(url);
        req.addResponseListener((e)-> {
           
            String str = new String(req.getResponseData());
            System.out.println("data == "+str);
        
        });
       NetworkManager.getInstance().addToQueueAndWait(req);
        
   
   }
    
    
    
    
}
