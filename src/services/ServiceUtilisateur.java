/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import utils.UserSession;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import entites.Client;
import gui.SignInForm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.Statics;

/**
 *
 * @author Hassene
 */
public class ServiceUtilisateur {
    public Client client;
    
    public static ServiceUtilisateur instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceUtilisateur() {
        req = new ConnectionRequest();
    }
    
    public static ServiceUtilisateur getInstance() {
        if (instance == null) {
            instance = new ServiceUtilisateur();
        }
        return instance;
    }
    public boolean Connect(String email,String password){
        String url = Statics.BASE_URL + "/CheckUser";//création de l'URL
Boolean state  = false;
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        
   req.addArgument("email", email);
   req.addArgument("password", password);
    req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                if(resultOK = req.getResponseCode() == 200){
        client = parseClient(new String(req.getResponseData()));
UserSession.setInstace(client);
        System.out.println(UserSession.getInstace().getClient());
        System.out.println(UserSession.getInstace().getClient());
                    SignInForm.login = true;
          Dialog.show("Login", "Succes","ok","cancel");
                }else {
           Dialog.show("Login", "Verifier vos parametres","ok","cancel");
                               SignInForm.login = false;
                }
                    //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    public boolean addUtilisateur(Client t) {
        String url = Statics.BASE_URL + "/addClient";//création de l'URL

        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        
   req.addArgument("nom", t.getNom());
   req.addArgument("prenom",t.getPrenom());
   req.addArgument("email", t.getEmail());
   req.addArgument("password", t.getPassword());
   req.addArgument("adresse", t.getAdresse());
   req.addArgument("telephone", String.valueOf(t.getTelephone()));
   
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
    public boolean editUtilisateur(Client t) {
        String url = Statics.BASE_URL + "/EditClient";//création de l'URL
    req.setUrl(url);// Insertion de l'URL de notre demande de connexion
   req.addArgument("id",String.valueOf( t.getId()));    
   req.addArgument("nom", t.getNom());
   req.addArgument("prenom",t.getPrenom());
   req.addArgument("email", t.getEmail());
   req.addArgument("adresse", t.getAdresse());
   req.addArgument("telephone", String.valueOf(t.getTelephone()));
          

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
    
     public Client parseClient(String jsonText){
         Client t=null;
        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            
            Map<String,Object> obj = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
                                 System.out.println(jsonText);
                     System.out.println(obj.get("Telephone").toString());
                  //   System.out.println(Long.parseLong(obj.get("Telephone")));

                                 t = new Client();
                float id = Float.parseFloat(obj.get("id").toString());
                                float telephone = Float.parseFloat(obj.get("Telephone").toString());

                t.setId((int)id);
                t.setNom(obj.get("nom").toString());
                t.setPrenom(obj.get("prenom").toString());
                t.setEmail(obj.get("email").toString());
                t.setPassword(obj.get("password").toString());
                t.setAdresse(obj.get("Adresse").toString());
                t.setTelephone((int)telephone);
                t.setImage_name((String) obj.get("imageName"));
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
