/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoproject.Formular;

import java.util.ArrayList;
import java.util.Arrays;
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

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/auftrag.fxml"));
		root.getStyleClass().add("formPane");
		ArrayList showOnStartNotNewAufgrag = new ArrayList<String>(Arrays.asList("searchAuftragLabel", "searchAuftrag"));
		ArrayList hideOnStartNewAufgrag = new ArrayList<String>(Arrays.asList("searchAuftragLabel", "searchAuftrag"));
		
		root.getChildrenUnmodifiable().forEach((Node n) -> {
			if (
				n instanceof Node && (
					(! this.isNew && ! showOnStartNotNewAufgrag.contains(n.getId()))
					|| (this.isNew && hideOnStartNewAufgrag.contains(n.getId()))
				)
			) {
				n.setVisible(false);
			}
		});

		Scene scene = new Scene(root, 800, 600);
		stage.setScene(scene);
		stage.show();
	}
	
	/**
	 * 
	 * @param event 
	 */
	@FXML
	protected void searchAuftragMouseClick(ActionEvent event)
	{
//		System.out.println(event.getEventType().toString());
	}
	
	/**
	 * 
	 * @param event 
	 */
	@FXML
	protected void searchAuftragKeyReleased(ActionEvent event)
	{
//		System.out.println(event.getEventType().toString());
	}
	

	/**
	 *
	 * @param isNew
	 */
	public void setIsNew(boolean isNew) {
		this.isNew = isNew;
	}
}
