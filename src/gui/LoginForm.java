/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import utils.UserSession;
import static com.codename1.charts.util.ColorUtil.WHITE;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.CENTER;
import static com.codename1.ui.CN.FACE_SYSTEM;
import static com.codename1.ui.CN.STYLE_PLAIN;
import static com.codename1.ui.CN.addNetworkErrorListener;
import static com.codename1.ui.CN.updateNetworkThreadCount;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import static com.codename1.ui.TextArea.PASSWORD;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import services.ServiceUtilisateur;

/**
 *
 * @author Hassene
 */
public class LoginForm {
      private Resources theme;
      private Form form;
      public LoginForm(){
 updateNetworkThreadCount(2);

        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature
        Log.bindCrashProtection(true);

        addNetworkErrorListener(err -> {
            // prevent the event from propagating
            err.consume();
            if(err.getError() != null) {
                Log.e(err.getError());
            }
            Log.sendLogAsync();
            Dialog.show("Connection Error", "There was a networking error in the connection to " + err.getConnectionRequest().getUrl(), "OK", null);
        });        
        
        
          form = new Form();
              UIBuilder uib = new UIBuilder();
        Container c1 = uib.createContainer(theme, "LoginGUI");
        form = (Form) c1 ;
        
        Container LoginInputs = new  Container();
        LoginInputs.setLayout(BoxLayout.y());
        
       TextField email = new TextField();
        TextField password = new TextField();

       Style sinputs = new Style();
       sinputs.setBgTransparency(0);
      sinputs.setFgColor(WHITE);
       sinputs.setMarginLeft(74);
       sinputs.setBorder(Border.createUnderlineBorder(2,WHITE));
       sinputs.setFont(Font.createSystemFont(FACE_SYSTEM, STYLE_PLAIN, 17));
    
       email.setHint("E-mail");
       password.setHint("Mot de passe");
        password.setUnselectedStyle(sinputs);
        email.setUnselectedStyle(sinputs);
        password.setSelectedStyle(sinputs);
        email.setSelectedStyle(sinputs);
        
        email.setText("omar.elheni@esprit.tn");
        password.setText("stanger");
        
        Label oublie = new Label("Mot de passe oublié ?");
         oublie.setUIID("labeloublie");
        oublie.getAllStyles().setFgColor(WHITE);
        oublie.getAllStyles().setFont(Font.createSystemFont(FACE_SYSTEM, STYLE_PLAIN, 13));
        oublie.getAllStyles().setAlignment(CENTER);
        
       Button signin = new Button("Login");
       signin.getAllStyles().setFgColor(WHITE);
       signin.getAllStyles().setFont(Font.createSystemFont(FACE_SYSTEM, STYLE_PLAIN, 22));
       signin.getAllStyles().setBgTransparency(0);
       signin.getAllStyles().setBorder(Border.createInsetBorder(3, WHITE));
       signin.getAllStyles().setPadding(4,4, 9, 9);
       
Container LoginCon = new  Container();
      LoginCon.setLayout(BoxLayout.x());
      LoginCon.add(signin);
      LoginCon.getStyle().setMarginTop(74);
     LoginCon.getStyle().setMarginLeft(165);
     
     Button signup = new Button("Inscription");
       signup.getAllStyles().setFgColor(WHITE);
       signup.getAllStyles().setFont(Font.createSystemFont(FACE_SYSTEM, STYLE_PLAIN, 22));
       signup.getAllStyles().setBgTransparency(0);
       signup.getAllStyles().setBorder(Border.createInsetBorder(3, WHITE));
       signup.getAllStyles().setPadding(5,5, 10, 10);
      
Container InscCon = new  Container();
      InscCon.setLayout(BoxLayout.x());
      InscCon.add(signup);
      InscCon.getAllStyles().setMarginTop(50);
     InscCon.getAllStyles().setMarginLeft(147);
     
           Container LoginEmail = new  Container();
      LoginEmail.setLayout(BoxLayout.x());
Container LoginPass = new  Container();
      LoginPass.setLayout(BoxLayout.x());
       LoginPass.setHeight(80);
      LoginEmail.setHeight(80);
      LoginEmail.add(email);
      LoginPass.add(password);
     
      signup.addActionListener(l->{
          InscriptionForm li = new InscriptionForm(form);
 Form  current =   li.getForm();
  current.show();

      });
          signin.addActionListener(l->{
                        ServiceUtilisateur.getInstance().Connect(email.getText(), password.getText());
                      //     new PanierForm(theme).show();
                           System.out.println(UserSession.getInstace().getClient());
      });    
      
        password.setConstraint(PASSWORD);
        LoginInputs.addAll(LoginEmail,LoginPass,oublie,LoginCon,InscCon);
        form.add(LoginInputs);
      }
      
   public Form   getForm(){
         return form ; 
      }
}
