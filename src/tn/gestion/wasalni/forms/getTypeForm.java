package tn.gestion.wasalni.forms;

import com.codename1.l10n.ParseException;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.list.MultiList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.util.Resources;
import java.util.Collections;
import java.util.Comparator;
import tn.gestion.wasalni.model.Type;
import tn.gestion.wasalni.service.TypeWebService;

public class getTypeForm extends BaseForm {

    private MultiList eventList;
    List<Type> types;
    private TextField searchField;
    TypeWebService service = new TypeWebService();

    public getTypeForm() {
        this.init(Resources.getGlobalResources());
        eventList = new MultiList(new DefaultListModel<>());
        add(eventList);
        getAllTypes();

        Button sortButton = new Button("Trier");
        sortButton.addActionListener(e -> {
            Collections.sort(types, new Comparator<Type>() {
                @Override
                public int compare(Type p1, Type p2) {
                    return p1.getCategory().compareToIgnoreCase(p2.getCategory());
                }
            });
            updateList();
        });
        addComponent(BorderLayout.south(sortButton));
    }

    private void getAllTypes() {
        types = service.getAllType();
        DefaultListModel<Map<String, Object>> model = (DefaultListModel<Map<String, Object>>) eventList.getModel();
        model.removeAll();
        for (Type c : types) {
            Map<String, Object> item = new HashMap<>();
            item.put("Line1", "Categorie:" + c.getCategory());
            item.put("Line2", "Desc :" + c.getDescprition());
            item.put("Line3", c.getId());
            model.addItem(item);
        }
        eventList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    Map<String, Object> selectedItem = (Map<String, Object>) eventList.getSelectedItem();
                    int TypeId = (int) selectedItem.get("Line3");
                    Type selectedEvent = null;
                    for (Type c : types) {
                        if (c.getId() == TypeId) {
                            selectedEvent = c;
                            break;
                        }
                    }
                    editTypeForm myForm2 = new editTypeForm(selectedEvent);
                    myForm2.show();
                } catch (ParseException ex) {
                    System.out.println(ex);
                }
            }
        });

        searchField = new TextField("", "Enter Promotion Type");
        Button searchButton = new Button("Recherche");
        searchButton.addActionListener(e -> {
            try {
                String searchId = searchField.getText();
                Type selectedPromo = null;
                for (Type p : types) {
                    if (p.getCategory()== null ? searchId == null : p.getCategory().equals(searchId)) {
                        selectedPromo = p;
                        break;
                    }
                }
                if (selectedPromo != null) {
                    editTypeForm myForm2 = new editTypeForm(selectedPromo);
                    myForm2.show();
                } else {
                    Dialog.show("Error", "Promotion not found", "OK", null);
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

    private void updateList() {
        DefaultListModel<Map<String, Object>> model = (DefaultListModel<Map<String, Object>>) eventList.getModel();
        model.removeAll();
        for (Type c : types) {
            Map<String, Object> item = new HashMap<>();
            item.put("Line1", "Categorie:" + c.getCategory());
            item.put("Line2", "Desc :" + c.getDescprition());
            item.put("Line3", c.getId());
            model.addItem(item);
        }
    }
}
