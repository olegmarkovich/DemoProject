/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoproject.Formular;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Lenovo
 */
public class KundenController extends Application {
                
    private boolean isNew;
    
    @FXML private TextField newKunde;
    @FXML private TextField txtName;
    @FXML private TextField txtVorname;
    @FXML private TextField txtStrasse;
    @FXML private TextField txtHausnummer;
    @FXML private TextField txtPLZ;
    @FXML private TextField txtStadt;
    @FXML private TextField txtOrt;
    @FXML private TextField txtTel;
    @FXML private TextField txtMail;
    
    /**
	 *
	 * @param event
	 */
    @FXML
    public void handleSubmitButtonAction(ActionEvent event) {
		System.out.println("demoproject.Formular.KundenController.handleSubmitButtonAction()");
	}
    
    
    @Override
    public void start(Stage stage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/kunde.fxml"));
		root.getStyleClass().add("formPane");
		root.getChildrenUnmodifiable().forEach((Node n) -> {
			if (this.isNew && n instanceof Node && "saveButton".equals(n.getId())) {
				n.setVisible(true);
			}
		});

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }
        /**
	 *
	 * @param isNew
	 */
    
	public void setIsNew(boolean isNew) {
            this.isNew = isNew;
	}
}
