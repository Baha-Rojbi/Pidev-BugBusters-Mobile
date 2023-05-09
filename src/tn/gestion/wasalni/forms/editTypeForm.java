package tn.gestion.wasalni.forms;

import com.codename1.l10n.ParseException;
import com.codename1.ui.Button;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;
import tn.gestion.wasalni.model.Type;
import tn.gestion.wasalni.service.TypeWebService;

public class editTypeForm extends BaseForm {

    TypeWebService service = new TypeWebService();
    public editTypeForm(Type e) throws ParseException {
        this.init(Resources.getGlobalResources());
        TextField nomField = new TextField(e.getCategory(), "name");
        TextField descField = new TextField(e.getDescprition(), "desc");
        this.add(nomField);
        this.add(descField);
        Button submitButton = new Button("Update");
        submitButton.addActionListener(s-> {
            String nom = nomField.getText();
            String slug = descField.getText();

            Type type = new Type();
            type.setId(e.getId());
            type.setCategory(nom);
            type.setDescprition(slug);
            
            service.editType(type);
            
            getTypeForm myForm = new getTypeForm();
            myForm.show();
        }
        );
        Button goToFormButton = new Button("Go back");
        goToFormButton.addActionListener(ee -> {
            getTypeForm myForm = new getTypeForm();
            myForm.show();
        });
        Button deleteButton = new Button("Delete");
        deleteButton.addActionListener(cc -> {
            service.delType(e);
            
            getTypeForm myForm = new getTypeForm();
            myForm.show();
        });
        this.add(deleteButton);
        this.add(goToFormButton);
        this.add(submitButton);
    }

}
