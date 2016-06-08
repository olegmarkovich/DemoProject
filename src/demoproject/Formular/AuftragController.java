/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoproject.Formular;

import demoproject.finder.Auftrag;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Lenovo
 */
public class AuftragController extends Application {

	private boolean isNew;
	
	@FXML private TextField searchAuftrag;

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

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	/**
	 * action bei maus click
	 * @param event 
	 */
	@FXML
	protected void searchAuftragMouseClick(MouseEvent event) throws SQLException, ClassNotFoundException
	{
		this.findAuftraege(this.searchAuftrag.getCharacters().toString());
	}
	
	/**
	 * action bei taste los lässt
	 * @param event 
	 */
	@FXML
	protected void searchAuftragKeyReleased(KeyEvent event) throws SQLException, ClassNotFoundException
	{
		if (event.getCode() == KeyCode.ENTER) {
			this.findAuftraege(this.searchAuftrag.getCharacters().toString());
		}
	}
	
	/**
	 * finde aufträge
	 * @param searchValue
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	private void findAuftraege(String searchValue) throws SQLException, ClassNotFoundException 
	{
		this.searchAuftrag.setDisable(true);
		try {
			ArrayList res = new ArrayList();
			demoproject.finder.Auftrag aFinder = new Auftrag();
			res = aFinder.findAutraege(searchValue);
		} catch (Exception e) {
			new demoproject.Error(e.getMessage());
			System.out.println(e.getMessage() + " " + e.getClass().toString());
		} finally {
			this.searchAuftrag.setDisable(false);
		}
	}
	

	/**
	 * setze ob es um den neuen Autrag handelt, oder ein neuen gemacht wird
	 * @param isNew
	 */
	public void setIsNew(boolean isNew) {
		this.isNew = isNew;
	}
}
