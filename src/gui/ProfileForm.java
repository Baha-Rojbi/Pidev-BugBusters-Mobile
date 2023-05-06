/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */

package gui;

import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import com.codename1.ui.Display;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import entites.Client;
import java.io.IOException;
import services.ServiceUtilisateur;



import utils.UserSession;

/**
 * The user profile form
 *
 * @author Shai Almog
 */
public class ProfileForm extends BaseForm {

    public ProfileForm(Resources res) {
   super("Newsfeed", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Profile");
        getContentPane().setScrollVisible(false);
        
        super.addSideMenu(res);
        
        tb.addSearchCommand(e -> {});
        Client c;
        Image img = res.getImage("profile-background.jpg");
      /*  Image img=null;
        try {
            img = Image.createImage("file:/C:/Users/Hassene/Documents/Symfony/Hytaco/public/images/properties/" + c.getImage_name()).fill(80, 80);
        } catch (IOException ex) {
        }*/
        if(img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

        Label facebook = new Label("786 followers", res.getImage("facebook-logo.png"), "BottomPad");
        Label twitter = new Label("486 followers", res.getImage("twitter-logo.png"), "BottomPad");
        facebook.setTextPosition(BOTTOM);
        twitter.setTextPosition(BOTTOM);
        
       /*
        TextField nom = new TextField(c.getNom());
        nom.setUIID("TextFieldBlack");
        addStringValue("Nom", nom);
        
        TextField prenom = new TextField(c.getPrenom());
        nom.setUIID("TextFieldBlack");
        addStringValue("Prenom", prenom);

        TextField email = new TextField(c.getEmail(), "E-Mail", 20, TextField.EMAILADDR);
        email.setUIID("TextFieldBlack");
        addStringValue("E-Mail", email);
        
        TextField adresse = new TextField(c.getAdresse());
        nom.setUIID("TextFieldBlack");
        addStringValue("Adresse", adresse);
        
TextField telephone = new TextField(String.valueOf(c.getTelephone()));
        nom.setUIID("TextFieldBlack");
        addStringValue("Telephone", telephone);
        /*  signup.addActionListener(l->{
             Client client = new Client(nom.getText(),prenom.getText(),Integer.parseInt(telephone.getText()),adresse.getText(),password.getText(),email.getText(),null,null);
             ServiceUtilisateur.getInstance().addUtilisateur(client);
      });*/
       Button edit = new Button("Modifier");
       edit.addActionListener(l->{
          //   Client client = new Client(c.getId(),nom.getText(),prenom.getText(),Integer.parseInt(telephone.getText()),adresse.getText(),email.getText(),null);
         //    ServiceUtilisateur.getInstance().editUtilisateur(client);
      });
       add(edit);
    }
    private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel")).
                add(BorderLayout.CENTER, v));
        add(createLineSeparator(0xeeeeee));
    }
}
