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
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;

/**
 *
 * @author bahar
 */
public class editVoitureForm extends BaseFormVoiture{
    
   VoitureLocationService service = new VoitureLocationService();
    public editVoitureForm(VoitureLocation e) throws ParseException {
        this.init(Resources.getGlobalResources());
        
        TextField modeleField = new TextField(e.getModele(), "modele");
        TextField matriculeField = new TextField(e.getMatricule(), "matricule");
        TextField prixField = new TextField(String.valueOf(e.getPrix_jour()), "prix_jour");
        TextField carteField = new TextField(e.getCarte_grise(), "carte_grise");
        
        this.add(modeleField);
        this.add(matriculeField);
        this.add(prixField);
        this.add(carteField);
        
        Button submitButton = new Button("Submit");
        submitButton.addActionListener(s-> {
            String modele = modeleField.getText();
            String matricule = matriculeField.getText();
            int prix_jour = Integer.parseInt(prixField.getText());
            String carte_grise = carteField.getText();

            VoitureLocation voiture = new VoitureLocation();
            voiture.setId_voiture(e.getId_voiture());
            voiture.setModele(modele);
            voiture.setMatricule(matricule);
            voiture.setPrix_jour(prix_jour);
            voiture.setCarte_grise(carte_grise);
            
            service.editVoiture(voiture);
            getVoitureForm myForm = new getVoitureForm();
            myForm.show();
        }
        );
        Button goToFormButton = new Button("Go back");
        goToFormButton.addActionListener(ee -> {
            getVoitureForm myForm = new getVoitureForm();
            myForm.show();
        });
        Button deleteButton = new Button("Delete");
        deleteButton.addActionListener(cc -> {
            service.delVoiture(e);
            getVoitureForm myForm = new getVoitureForm();
            myForm.show();
        });
        this.add(deleteButton);
        this.add(goToFormButton);
        this.add(submitButton);
    }
    
}
