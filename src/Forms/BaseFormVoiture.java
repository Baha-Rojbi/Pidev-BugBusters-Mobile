/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author bahar
 */
public class BaseFormVoiture extends com.codename1.ui.Form {
    
    public void init(Resources theme) {
        Toolbar tb = getToolbar();

        tb.getAllStyles().setBgColor(0xffffff);

        Image logo = theme.getImage("logo.png");
        Label logoLabel = new Label(logo);
        Container logoContainer = BorderLayout.center(logoLabel);
        logoContainer.setUIID("SideCommandLogo");
        tb.addComponentToSideMenu(logoContainer);

        Label taglineLabel = new Label("Gestion Voiture location");
        taglineLabel.setUIID("SideCommandTagline");
        Container taglineContainer = BorderLayout.south(taglineLabel);
        taglineContainer.setUIID("SideCommand");

        tb.addComponentToSideMenu(taglineContainer);
        tb.addMaterialCommandToSideMenu("List des voiture locations", FontImage.MATERIAL_LIST, e -> {
            getVoitureForm f = new getVoitureForm();
            f.show();
        });
        tb.addMaterialCommandToSideMenu("Ajouter une voiture", FontImage.MATERIAL_ADD, e -> {
            newVoitureForm f = new newVoitureForm();
            f.show();
        });
    }
    
}
