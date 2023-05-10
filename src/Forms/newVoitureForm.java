/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Entities.VoitureLocation;
import Services.VoitureLocationService;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


/**
 *
 * @author bahar
 */
public class newVoitureForm extends BaseFormVoiture{
    private static final String ACCOUNT_SID = "AC1d39955a23413357ea2300498f56f78c";
    private static final String AUTH_TOKEN = "b8baa4a49c5ef0ae44419814244ced2a";

    // The Twilio phone number you want to use to send SMS messages
    private static final String TWILIO_NUMBER = "+16318835768";

    // The recipient phone number you want to send an SMS message to
    private static final String RECIPIENT_NUMBER = "+21653802106";
    
    public newVoitureForm() {
        this.init(Resources.getGlobalResources());
        TextField modeleField = new TextField("", "modele");
        TextField matriculeField = new TextField("", "matricule");
        TextField prixField = new TextField("", "prix_jour");
        TextField carteField = new TextField("", "carte_grise");
        

        this.add(modeleField);
        this.add(matriculeField);
        this.add(prixField);
        this.add(carteField);
        

        Button submitButton = new Button("Submit");

       submitButton.addActionListener(s -> {
    String modele = modeleField.getText();
    String matricule = matriculeField.getText();
    String prixJourStr = prixField.getText();
    String carteGrise = carteField.getText();

    if (modele.isEmpty() || matricule.isEmpty() || prixJourStr.isEmpty() || carteGrise.isEmpty()) {
        // Create a new dialog with an error message
        Dialog.show("Error", "All fields are required", "OK", null);
        return;
    }

    int prixJour = Integer.parseInt(prixJourStr);

    VoitureLocation newCar = new VoitureLocation();
    newCar.setModele(modele);
    newCar.setMatricule(matricule);
    newCar.setPrix_jour(prixJour);
    newCar.setCarte_grise(carteGrise);
    VoitureLocationService service = new VoitureLocationService();
    service.newVoiture(newCar);
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        // Send an SMS message using the Twilio API
        Message message = Message.creator(
            new PhoneNumber(RECIPIENT_NUMBER),
            new PhoneNumber(TWILIO_NUMBER),
            "Voiture ajoutée!"
        ).create();

        // Print the message SID to the console
        System.out.println("SMS message sent with SID: " + message.getSid());
    
});


        this.add(submitButton);
        Button goToFormButton = new Button("Go Back");
        goToFormButton.addActionListener(e -> {
            getVoitureForm myForm = new getVoitureForm();
            myForm.show();
        });
        this.add(goToFormButton);
    }
}
