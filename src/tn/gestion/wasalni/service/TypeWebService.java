package tn.gestion.wasalni.service;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tn.gestion.wasalni.model.Type;

public class TypeWebService {

    private static final String BASE_URL = "http://127.0.0.1:8000/api";
    private ConnectionRequest connection;

    public TypeWebService() {
        connection = new ConnectionRequest();
        connection.setInsecure(true);
    }

    public List<Type> getAllType() {
        String url = BASE_URL + "/type";
        this.connection.setUrl(url);
        this.connection.setHttpMethod("GET");
        List<Type> categories = new ArrayList<>();
        this.connection.addResponseListener(e -> {  
            if (this.connection.getResponseCode() == 200) {
                String response = new String(this.connection.getResponseData());
                try {
                    JSONArray jsonEvents = new JSONArray(response);
                    for (int i = 0; i < jsonEvents.length(); i++) {
                        JSONObject jsonEvent = jsonEvents.getJSONObject(i);
                        Type categorie = new Type(
                                jsonEvent.getInt("id"),
                                jsonEvent.getString("category"),
                                jsonEvent.getString("descprition")
                        );
                        categories.add(categorie);
                    }
                } catch (JSONException ex) {
                    ex.printStackTrace();
                }
            } else {
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(this.connection);
        return categories;
    }

    public void newType(Type c) {
        connection = new ConnectionRequest();
        connection.setInsecure(true);
        this.connection.setUrl(BASE_URL + "/type/add");
        this.connection.setHttpMethod("POST");
        
        connection.addArgument("category", c.getCategory());
        connection.addArgument("descprition", c.getDescprition());

        NetworkManager.getInstance().addToQueue(connection);
    }
    
    public void editType(Type c) {
        connection = new ConnectionRequest();
        connection.setInsecure(true);
        this.connection.setUrl(BASE_URL + "/type/"+c.getId());
        this.connection.setHttpMethod("PUT");
        connection.addArgument("category", c.getCategory());
        connection.addArgument("descprition", c.getDescprition());
        NetworkManager.getInstance().addToQueue(connection);
    }
    
    public void delType(Type c) {
        connection = new ConnectionRequest();
        connection.setInsecure(true);
        this.connection.setUrl(BASE_URL + "/type/"+c.getId());
        this.connection.setHttpMethod("DELETE");
        NetworkManager.getInstance().addToQueue(connection);
    }

}
