/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Livraison;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.Map;
import utils.Statics;

/**
 *
 * @author dell
 */
public class ServicesLivraisons {
        public Livraison client;
    
    public static ServicesLivraisons instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServicesLivraisons() {
        req = new ConnectionRequest();
    }
    
    public static ServicesLivraisons getInstance() {
        if (instance == null) {
            instance = new ServicesLivraisons();
        }
        return instance;
    }
    
     public boolean addLivraison(Livraison t,int com) {
        String url = Statics.BASE_URL + "/AddLivr";//création de l'URL

        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        
   req.addArgument("adresse", t.getAdresse());
   req.addArgument("date",t.getDatelivraison().toString());
   req.addArgument("idc", String.valueOf(com));
   
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                if(resultOK = req.getResponseCode() == 200){
                client = parseClient(new String(req.getResponseData()));
                
           Dialog.show("Inscription", "Succes","ok","cancel");
                }else {
           Dialog.show("Inscription", "Verifier vos parametres","ok","cancel");
    
                }
                    //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
     
     public Livraison parseClient(String jsonText){
         Livraison t=null;
        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            
            Map<String,Object> obj = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
                                 System.out.println(jsonText);
                     System.out.println(obj.get("Telephone").toString());
                  //   System.out.println(Long.parseLong(obj.get("Telephone")));

                                 t = new Livraison();
                float id = Float.parseFloat(obj.get("id").toString());
                                float telephone = Float.parseFloat(obj.get("Telephone").toString());

                t.setId((int)id);
                t.setDatelivraison(obj.get("date").toString());
                t.setAdresse(obj.get("prenom").toString());

                //Ajouter la tâche extraite de la réponse Json à la liste
                     System.out.println(t);

        } catch (IOException ex) {
            
        }finally{
         /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        */
        return t;
        }
    }
}
