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
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import entites.Client;
import entites.Commande;
import entites.produits;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import utils.Statics;
import utils.UserSession;

/**
 *
 * @author Hassene
 */
public class ServiceCommande {
        public Commande commande;
            public static ServiceCommande instance=null;

            public boolean resultOK;
    private ConnectionRequest req;

    public ServiceCommande() {
        req = new ConnectionRequest();
    }
    
    public static ServiceCommande getInstance() {
        if (instance == null) {
            instance = new ServiceCommande();
        }
        return instance;
    }
     public boolean topaye(int id) {
         boolean status = false ;
        String url = Statics.BASE_URL + "/topaye/"+id;//création de l'URL
 req.setUrl(url);
        req.setPost(false);
        req.addResponseListener((l)->{
             if( req.getResponseCode() == 200){
                      resultOK = true ;
                  }else {
                                      resultOK = false ;
 
             }

        });
              NetworkManager.getInstance().addToQueueAndWait(req);
           return    resultOK ;
              
     }
     public Commande addCommande() {
        String url = Statics.BASE_URL + "/AjoutComm";//création de l'URL
                HashMap<produits,Integer> prs =   UserSession.getInstace().getPanier();
 req.setUrl(url);
        req.setPost(false);
                    req.addArgument("user", String.valueOf(UserSession.getInstace().getClient().getId()));

        for(produits i : prs.keySet()){
            req.addArgument(String.valueOf(i.getId_produit()), String.valueOf(prs.get(i)));
        }
       

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                if(resultOK = req.getResponseCode() == 200){
                commande = parseCommande(new String(req.getResponseData()));
                
          Dialog.show("Ajout Commande", "Succes","ok","cancel");
                }else {
           Dialog.show("Ajout Commande", "Verifier vos parametres","ok","cancel");
    
                }
                    //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return commande;
    }
     
      public Commande parseCommande(String jsonText){
         Commande t=null;
        try {
            JSONParser j = new JSONParser();
            Map<String,Object> obj = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
           
                t = new Commande();
                float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
                t.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(obj.get("dateCommande").toString()));
                t.setPrix(Double.parseDouble(obj.get("prix").toString()));

                //Ajouter la tâche extraite de la réponse Json à la liste
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
