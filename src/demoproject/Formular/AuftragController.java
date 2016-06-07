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
import javafx.stage.Stage;

/**
 *
 * @author Lenovo
 */
public class AuftragController extends Application {

	private boolean isNew;

	/**
	 *
	 * @param event
	 */
	@FXML
	public void handleSubmitButtonAction(ActionEvent event) {
		System.out.println("demoproject.Formular.AuftragController.handleSubmitButtonAction()");
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/form.fxml"));
		root.getStyleClass().add("formPane");
		root.getChildrenUnmodifiable().forEach((Node n) -> {
			if (this.isNew && n instanceof Node && "searchButton".equals(n.getId())) {
				n.setVisible(false);
			}
			System.out.println(n.getId());
		});

		Scene scene = new Scene(root, 800, 600);
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
