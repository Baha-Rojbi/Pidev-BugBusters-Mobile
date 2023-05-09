package tn.gestion.wasalni.forms;

import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.Resources;

public class BaseForm extends com.codename1.ui.Form {

    public void init(Resources theme) {
        Toolbar tb = getToolbar();

        tb.getAllStyles().setBgColor(0xffffff);

        Image logo = theme.getImage("logo.png");
        Label logoLabel = new Label(logo);
        Container logoContainer = BorderLayout.center(logoLabel);
        logoContainer.setUIID("SideCommandLogo");
        tb.addComponentToSideMenu(logoContainer);

        Label taglineLabel = new Label("Gestion Type");
        taglineLabel.setUIID("SideCommandTagline");
        Container taglineContainer = BorderLayout.south(taglineLabel);
        taglineContainer.setUIID("SideCommand");

        tb.addComponentToSideMenu(taglineContainer);
        tb.addMaterialCommandToSideMenu("List Type", FontImage.MATERIAL_LIST, e -> {
            getTypeForm f = new getTypeForm();
            f.show();
        });
        tb.addMaterialCommandToSideMenu("Ajouter Type", FontImage.MATERIAL_ADD, e -> {
            newTypeForm f = new newTypeForm();
            f.show();
        });
    }
}
