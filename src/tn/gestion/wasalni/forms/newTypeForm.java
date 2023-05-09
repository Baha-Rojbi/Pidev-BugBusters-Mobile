package tn.gestion.wasalni.forms;

import com.codename1.ui.Button;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;
import tn.gestion.wasalni.model.Type;
import tn.gestion.wasalni.service.TypeWebService;

public class newTypeForm extends BaseForm {

    public newTypeForm() {
        this.init(Resources.getGlobalResources());
        TextField nomField = new TextField("", "Nom");
        TextField slugField = new TextField("", "Description");

        this.add(nomField);

        this.add(slugField);

        Button submitButton = new Button("Ajouter");

        submitButton.addActionListener(s
                -> {
            String nom = nomField.getText();
            String slug = slugField.getText();

            Type newType = new Type();
            newType.setCategory(nom);
            newType.setDescprition(slug);
            TypeWebService service = new TypeWebService();
            service.newType(newType);
        }
        );
        this.add(submitButton);
        Button goToFormButton = new Button("Go Back");
        goToFormButton.addActionListener(e -> {
            getTypeForm myForm = new getTypeForm();
            myForm.show();
        });
        this.add(goToFormButton);
    }

}
