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
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import entites.Locaux;
import entites.Programmes;

import utils.Statics;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Hass
 */
public class ServiceProgrammes {
    



public static ServiceProgrammes instance = null ;

private ConnectionRequest req;

public static ServiceProgrammes getInstance()
{
if (instance == null)
instance = new ServiceProgrammes();
return instance;
}
        

public ServiceProgrammes(){ 
req = new ConnectionRequest();
}  


  


//ajout
public void ajoutProgrammes(Programmes programmes)
{
String url =Statics.BASE_URL+"/AddProg?nom="+programmes.getNom()+"&date="+programmes.getDate()+"&duree="+programmes.getDuree()+"&details="+programmes.getDetails()+"&locale="+programmes.getLoc().getNom();
req.setUrl(url);
req.addResponseListener((e)->{
    String str = new String(req.getResponseData());
    System.out.println("data=="+str);
});        
        
NetworkManager.getInstance().addToQueueAndWait(req);
               
}


public Locaux Getlocaux(int id){
Locaux result = new Locaux() ;

String url =Statics.BASE_URL+"/GetLoc?id="+id;  
     System.out.print(url);

req.setUrl (url);
req.addResponseListener(new ActionListener<NetworkEvent>() {
@Override    
public void actionPerformed(NetworkEvent evt){
 JSONParser jsonp;
 jsonp = new JSONParser();
 try {
Map<String,Object>obj = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));


float id=Float.parseFloat(obj.get("id").toString());
String nom=obj.get("nom").toString();
String adresse=obj.get("adresse").toString();
String description=obj.get("description").toString();
String imageName=obj.get("imageName").toString();
float note=Float.parseFloat(obj.get("note").toString());
String googleMap=obj.get("googleMap").toString();

result.setId((int)id);
result.setNom(nom);
result.setAdresse(adresse);
result.setDescription(description);
result.setImageName(imageName);
result.setNote((int)note);      
result.setGoogleMap(googleMap);


                req.removeResponseListener(this); //Supprimer cet actionListener


 }catch(Exception ex){
     ex.printStackTrace();
     
 }



}

  
    
});

NetworkManager.getInstance().addToQueueAndWait(req);

return result;

}
        
//affichage
public ArrayList<Programmes>affichageProgrammes(){
ArrayList<Programmes> result = new ArrayList<>();  

    
String url =Statics.BASE_URL+"/ShowProg";  
     System.out.print(url);

req.setUrl (url);
req.addResponseListener(new ActionListener<NetworkEvent>() {
 @Override
            public void actionPerformed(NetworkEvent evt) {
 JSONParser jsonp;
 jsonp = new JSONParser();
     System.out.println(req.getResponseData());

 try {

Map<String,Object>mapProgrammes = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));

List<Map<String,Object>> listOfMaps = (List<Map<String,Object>>) mapProgrammes.get("root");

for(Map<String , Object> obj : listOfMaps){
Programmes prog = new Programmes();


float id=Float.parseFloat(obj.get("id").toString());
String nom=obj.get("nom").toString();
String details=obj.get("details").toString();
float duree=Float.parseFloat(obj.get("duree").toString());
String date=obj.get("date").toString();


prog.setId((int)id);
prog.setNom(nom);
prog.setDetails(details);
prog.setDuree((int)duree);

  
prog.setDate(date.toString());

                 req.removeResponseListener(this); //Supprimer cet actionListener
prog.setLoc(Getlocaux((int)id));

//Date
/*String DateConverter = obj.get("date").toString().substring(obj.get("date").toString().indexOf("timestamp")+10 , obj.get("obj").toString().lastIndexOf("}"));
Date currentTime = new Date(Double.valueOf(DateConverter).longValue()*1000);
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
String dateString = formatter.format(currentTime);
prog.setDate(dateString);*/




result.add(prog);
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
