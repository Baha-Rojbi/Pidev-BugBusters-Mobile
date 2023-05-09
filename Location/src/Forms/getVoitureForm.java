/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Entities.VoitureLocation;
import Services.VoitureLocationService;
import com.codename1.l10n.ParseException;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.MultiList;
import com.codename1.ui.util.Resources;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bahar
 */
public class getVoitureForm extends BaseFormVoiture{
    
    private MultiList eventList;
    List<VoitureLocation> cars;
    private TextField searchField;
    VoitureLocationService service = new VoitureLocationService();

    public getVoitureForm() {
        this.init(Resources.getGlobalResources());
        eventList = new MultiList(new DefaultListModel<>());
        add(eventList);
        getAllCars();
        
        Button sortButton = new Button("Sort by modele");
        sortButton.addActionListener(e -> {
            Collections.sort(cars, new Comparator<VoitureLocation>() {
                @Override
                public int compare(VoitureLocation p1, VoitureLocation p2) {
                    return p1.getModele().compareToIgnoreCase(p2.getModele());
                }
            });
            updateList();
        });
        
        Button sortButton2 = new Button("Sort by Price");
        sortButton2.addActionListener(e -> {
            Collections.sort(cars, new Comparator<VoitureLocation>() {
        @Override
        public int compare(VoitureLocation p1, VoitureLocation p2) {
            return Integer.compare(p1.getPrix_jour(), p2.getPrix_jour());
        }
    });
    updateList();
});
        
        addComponent(BorderLayout.south(sortButton2));
        addComponent(BorderLayout.south(sortButton));
    }
    
    ///////////////
    private void updateList() {
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
    }
    //////////////////
    private void getAllCars() {
        VoitureLocationService service = new VoitureLocationService();
        cars = service.getAllVoiture();

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
        
        searchField = new TextField("", "Search by modele");
        Button searchButton = new Button("Search");
        searchButton.addActionListener(e -> {
            try {
                String searchId = searchField.getText();
                VoitureLocation selectedPromo = null;
                for (VoitureLocation p : cars) {
                    if (p.getModele()== null ? searchId == null : p.getModele().equals(searchId)) {
                        selectedPromo = p;
                        break;
                    }
                }
                if (selectedPromo != null) {
                    editVoitureForm myForm2 = new editVoitureForm(selectedPromo);
                    myForm2.show();
                } else {
                    Dialog.show("Error", "Modele not found", "OK", null);
                }
            } catch (NumberFormatException ex) {
                Dialog.show("Error", "Invalid ID", "OK", null);
            } catch (ParseException ex) {
                System.out.println(ex);
            }
        });
        Container searchContainer = BorderLayout.west(searchField).add(BorderLayout.EAST, searchButton);
        addComponent(searchContainer);

    }
    
}
