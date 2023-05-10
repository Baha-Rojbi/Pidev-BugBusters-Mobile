/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.VoitureLocation;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author bahar
 */
public class VoitureLocationService {
    private static final String BASE_URL = "http://127.0.0.1:8000/api";
    private ConnectionRequest connection;

    public VoitureLocationService() {
        connection = new ConnectionRequest();
        connection.setInsecure(true);
    }
    
    public List<VoitureLocation> getAllVoiture() {
        String url = BASE_URL + "/voiturelocation";
        this.connection.setUrl(url);
        this.connection.setHttpMethod("GET");
        List<VoitureLocation> Voiture = new ArrayList<>();
        this.connection.addResponseListener(e -> {
            if (this.connection.getResponseCode() == 200) {
                String response = new String(this.connection.getResponseData());
                try {
                    JSONArray jsonEvents = new JSONArray(response);
                    for (int i = 0; i < jsonEvents.length(); i++) {
                        JSONObject jsonEvent = jsonEvents.getJSONObject(i);
                        VoitureLocation voiture = new VoitureLocation(
                                jsonEvent.getInt("id_voiture"),
                                jsonEvent.getString("modele"),
                                jsonEvent.getString("matricule"),
                                jsonEvent.getInt("prix_jour"),
                                jsonEvent.getString("carte_grise")
                                
                                
                        );
                        Voiture.add(voiture);
                    }
                } catch (JSONException ex) {
                    ex.printStackTrace();
                }
            } else {
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(this.connection);
        return Voiture;
    }
     public void newVoiture(VoitureLocation c) {
        connection = new ConnectionRequest();
        connection.setInsecure(true);
        this.connection.setUrl(BASE_URL + "/voiturelocation/add");
        this.connection.setHttpMethod("POST");
        
        connection.addArgument("modele", c.getModele());
        connection.addArgument("matricule", c.getMatricule());
        connection.addArgument("prix_jour", Integer.toString(c.getPrix_jour()));
        connection.addArgument("carte_grise", c.getCarte_grise());
      
        NetworkManager.getInstance().addToQueue(connection);
    }
       public void editVoiture(VoitureLocation c) {
        connection = new ConnectionRequest();
        connection.setInsecure(true);
        this.connection.setUrl(BASE_URL + "/voiturelocation/"+c.getId_voiture());
        this.connection.setHttpMethod("PUT");
        connection.addArgument("modele", c.getModele());
        connection.addArgument("matricule", c.getMatricule());
        connection.addArgument("prix_jour", Integer.toString(c.getPrix_jour()));
        connection.addArgument("carte_grise", c.getCarte_grise());
        NetworkManager.getInstance().addToQueue(connection);
    }
       public void delVoiture(VoitureLocation c) {
        connection = new ConnectionRequest();
        connection.setInsecure(true);
        this.connection.setUrl(BASE_URL + "/voiturelocation/"+c.getId_voiture());
        this.connection.setHttpMethod("DELETE");
        NetworkManager.getInstance().addToQueue(connection);
    }
}
