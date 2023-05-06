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
import entites.Locaux;
import utils.Statics;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Hass
 */
public class ServiceLocaux {
    
public static ServiceLocaux instance = null ;

private ConnectionRequest req;

public static ServiceLocaux getInstance()
{
if (instance == null)
instance = new ServiceLocaux();
return instance;
}
        

public ServiceLocaux(){ 
req = new ConnectionRequest();
}        
  

//ajout
public void ajoutLocaux(Locaux locaux)
{
String url =Statics.BASE_URL+"/AddLoc?nom="+locaux.getNom()+"&adresse="+locaux.getAdresse()+"&description="+locaux.getDescription()+"&imageName="+locaux.getImageName()+"&note="+locaux.getNote()+"&googleMap="+locaux.getGoogleMap();
req.setUrl(url);
req.addResponseListener((e)->{
    String str = new String(req.getResponseData());
    System.out.println("data=="+str);
});        
        
NetworkManager.getInstance().addToQueueAndWait(req);
               
}



//affichage
public ArrayList<Locaux>affichageLocaux(){
ArrayList<Locaux> result = new ArrayList<>();  

    
String url =Statics.BASE_URL+"/ShowLoc";  
req.setUrl (url);
req.addResponseListener(new ActionListener<NetworkEvent>() {
@Override    
public void actionPerformed(NetworkEvent evt){
 JSONParser jsonp;
 jsonp = new JSONParser();
 try {
Map<String,Object>mapLocaux = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));

List<Map<String,Object>> listOfMaps = (List<Map<String,Object>>) mapLocaux.get("root");

for(Map<String , Object> obj : listOfMaps){
Locaux loc = new Locaux();
float id=Float.parseFloat(obj.get("id").toString());
String nom=obj.get("nom").toString();
String adresse=obj.get("adresse").toString();
String description=obj.get("description").toString();
String imageName=obj.get("imageName").toString();
float note=Float.parseFloat(obj.get("note").toString());
String googleMap=obj.get("googleMap").toString();

loc.setId((int)id);
loc.setNom(nom);
loc.setAdresse(adresse);
loc.setDescription(description);
loc.setImageName(imageName);
loc.setNote((int)note);      
loc.setGoogleMap(googleMap);

result.add(loc);
}

 }catch(Exception ex){
     ex.printStackTrace();
     
 }
}    
    
});

NetworkManager.getInstance().addToQueueAndWait(req);
return result;


}














}
