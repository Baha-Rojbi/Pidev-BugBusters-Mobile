/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Entities.VoitureLocation;
import Services.VoitureLocationService;
import com.codename1.l10n.ParseException;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.MultiList;
import com.codename1.ui.util.Resources;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bahar
 */
public class getVoitureForm extends BaseFormVoiture{
    
    private MultiList eventList;

    public getVoitureForm() {
        this.init(Resources.getGlobalResources());
        eventList = new MultiList(new DefaultListModel<>());
        add(eventList);
        getAllCars();
    }
    
    private void getAllCars() {
        VoitureLocationService service = new VoitureLocationService();
        List<VoitureLocation> cars = service.getAllVoiture();
        DefaultListModel<Map<String, Object>> model = (DefaultListModel<Map<String, Object>>) eventList.getModel();
        model.removeAll();
        for (VoitureLocation c : cars) {
            Map<String, Object> item = new HashMap<>();
            item.put("Line1", c.getId_voiture());
            item.put("Line2", "modele:" + c.getModele());
            item.put("Line3", "matricule :" + c.getMatricule());
            item.put("Line4", "prix jour :" + c.getPrix_jour());
            item.put("Line5", "carte grise :" + c.getCarte_grise());
            model.addItem(item);
        }
        eventList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    Map<String, Object> selectedItem = (Map<String, Object>) eventList.getSelectedItem();
                    int carId = (int) selectedItem.get("Line1");
                    VoitureLocation selectedEvent = null;
                    for (VoitureLocation c : cars) {
                        if (c.getId_voiture()== carId) {
                            selectedEvent = c;
                            break;
                        }
                    }
                    editVoitureForm myForm2 = new editVoitureForm(selectedEvent);
                    myForm2.show();
                } catch (ParseException ex) {
                    System.out.println(ex);
                }
            }
        });

    }
    
}
