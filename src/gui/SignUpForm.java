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

import com.codename1.capture.Capture;
import com.codename1.components.FloatingHint;
import com.codename1.components.ImageViewer;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import static com.codename1.io.Log.e;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import static com.codename1.ui.TextArea.NUMERIC;
import static com.codename1.ui.TextArea.PASSWORD;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import entites.Chauffeur;
import java.io.IOException;
import java.util.Date;
import com.codename1.io.Util;
import com.codename1.ui.Image;


import services.ServiceUtilisateur;

/**
 * Signup UI
 *
 * @author Shai Almog
 */
public class SignUpForm extends BaseForm {
String FileNameInServer;
    public SignUpForm(Resources res) {
        super(new BorderLayout());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        tb.setUIID("Container");
        getTitleArea().setUIID("Container");
        Form previous = Display.getInstance().getCurrent();
        tb.setBackCommand("", e -> previous.showBack());
        setUIID("SignIn");
        
        TextField nom = new TextField();
       TextField email = new TextField();
        TextField password = new TextField();
         TextField matricule = new TextField();
        TextField permis = new TextField();
        TextField imagel = new TextField();
        Button imageb = new Button();

         

       Container container = new Container(new BoxLayout(BoxLayout.Y_AXIS));
///////////////image
       Button uploadButton = new Button("Upload Image");


uploadButton.addActionListener(e -> {
    // Ouvrir la galerie pour sélectionner une image
    Display.getInstance().openGallery(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            if (evt != null && evt.getSource() != null) {
                String filePath = (String)evt.getSource();
                // Créer une nouvelle instance de Image pour l'image sélectionnée
                try {
                    Image img = Image.createImage(FileSystemStorage.getInstance().openInputStream(filePath));
                    // Ajouter l'image sélectionnée à votre formulaire
                    add(BorderLayout.NORTH, new ImageViewer(img));
                    // Mettre à jour l'affichage du formulaire
                    revalidate();
                } catch (IOException ex) {
                    Log.e(ex);
                }
            }
        }
    }, Display.GALLERY_IMAGE);
});
////////////////
        
        
         email.setHint("E-mail");
       password.setHint("Mot de passe");
       nom.setHint("Nom");
       matricule.setHint("Matricule");
       permis.setHint("Permis");
       password.setConstraint(PASSWORD);
        permis.setConstraint(NUMERIC);
        email.setSingleLineTextArea(false);
        password.setSingleLineTextArea(false);
        nom.setSingleLineTextArea(false);
        matricule.setSingleLineTextArea(false);
        permis.setSingleLineTextArea(false);
        password.setSingleLineTextArea(false);
        
        
        Button next = new Button("Next");
        Button signIn = new Button("Sign In");
        signIn.addActionListener(e -> previous.showBack());
        signIn.setUIID("Link");
        Label alreadHaveAnAccount = new Label("Already have an account?");
        
        Container content = BoxLayout.encloseY(
                new Label("Sign Up", "LogoLabel"),
                new FloatingHint(nom),
                createLineSeparator(),
                
                
                new FloatingHint(email),
                createLineSeparator(),
                new FloatingHint(password),
                createLineSeparator(),
                new FloatingHint(matricule),
                createLineSeparator(),
                new FloatingHint(permis),
                createLineSeparator()
                
        );
        
        content.setScrollableY(true);
        add(BorderLayout.CENTER, content);
        add(BorderLayout.SOUTH, BoxLayout.encloseY(
                uploadButton,
                next,
                FlowLayout.encloseCenter(alreadHaveAnAccount, signIn)
        ));
        
       
        
        next.requestFocus();
           signIn.addActionListener(l->{
         previous.showBack();
      });
           
         next.addActionListener(l->{
             Chauffeur client = new Chauffeur(nom.getText(), email.getText(), password.getText(), matricule.getText(), permis.getText());
           //  ServiceUtilisateur.getInstance().addUtilisateur(client);
//             String text = "Activation de votre compte\n" +
//"veuillez clicker sur le lien ci-dessus pour l'activer  votre compte\n" +
//"http://127.0.0.1:8000/activation/"+ client.getActivation_token();
//            try {
//                sendMail(res,client.getEmail(),text);
//            } catch (MessagingException ex) {
//            }
              new SignInForm(res).show() ;
      });
         
    }

}
