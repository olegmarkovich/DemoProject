/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoproject.Formular;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 *
 * @author Lenovo
 */
public final class Auftrag extends AbstractFormular{
    
    private boolean isNew = false;
    
    private Stage stage = null;
    
    private void setIsNew(boolean isNew)
    {
        this.isNew = isNew;
    }
    
    private void doAuftrag() {
        TextField aufNr = new TextField("Aurtragsnummer");
        aufNr.localToParent(0, 0);
        this.setElement(aufNr);
        Button search = new Button("Suche");
        search.localToParent(1000, 0);
        search.setDisable(isNew);
        search.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.print("search");
            }
        });
        this.setElement(search);
        
        this.show(this.stage, "Auftrag");
    }
    
    public Auftrag(Stage stage)
    {
        this.setIsNew(true);
        this.stage = stage;
        this.doAuftrag();
    }
    
    public Auftrag(Stage stage, boolean isNew)
    {
        this.setIsNew(isNew);
        this.stage = stage;
        this.doAuftrag();
    }
}
