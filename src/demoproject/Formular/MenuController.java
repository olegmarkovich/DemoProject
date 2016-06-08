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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Lenovo
 */
public class MenuController extends Application {

	private Stage stage = null;

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/menu.fxml"));
		root.getStyleClass().add("menuPane");
		Scene scene = new Scene(root, 800, 600);
		stage.setScene(scene);
		stage.show();
		this.stage = stage;
	}

	public Stage getStage() {
		if (null == this.stage) {
			this.stage = new Stage();
		}
		return this.stage;
	}

	@FXML
	protected void openExistingAuftrag(ActionEvent event) throws Exception {
		this.openAuftrag(false);
	}

	@FXML
	protected void openNewAuftrag(ActionEvent event) throws Exception {
		this.openAuftrag(true);
	}

	@FXML
	protected void closeApp(ActionEvent event) throws Exception {
		System.exit(0);
	}

	@FXML
	protected void openNewKunde(ActionEvent event) throws Exception {
		this.openKunde(true);
	}
        
        @FXML
	protected void openExistingKunde(ActionEvent event) throws Exception {
		this.openKunde(false);
	}

	/**
	 *
	 * @param isNew
	 * @throws java.lang.Exception
	 */
	private void openAuftrag(boolean isNew) throws Exception {
		AuftragController aController = new AuftragController();
		aController.setIsNew(isNew);
		try {
			aController.start(this.getStage());
		} catch (Exception e) {
			new demoproject.Error(e.getMessage());
		}
	}

	private void openKunde(boolean isNew) throws Exception {
		KundenController kController = new KundenController();
		kController.setIsNew(isNew);
		try {
			kController.start(this.getStage());
		} catch (Exception e) {
			new demoproject.Error(e.getMessage());
		}
	}
}
