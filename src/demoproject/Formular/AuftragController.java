/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoproject.Formular;

import demoproject.finder.Auftrag;
import demoproject.saver.SaveAufgrag;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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
	private ArrayList showOnStartNotNewAufgrag = new ArrayList<String>(Arrays.asList("searchAuftragLabel", "searchAuftrag"));
	private ArrayList hideOnStartNewAufgrag = new ArrayList<String>(Arrays.asList("searchAuftragLabel", "searchAuftrag"));
	
	@FXML private TextField searchAuftrag;
	@FXML private TextField newAuftrag;
	@FXML private ComboBox comboKundenname;
	@FXML private TextField newEingang;
	@FXML private TextField newArt;
	@FXML private TextField txtStrasse;
	@FXML private TextField txtHausnr;
	@FXML private TextField txtPLZ;
	@FXML private TextField txtStadt;
	@FXML private TextField txtGebaeude;
	@FXML private TextField txtEtage;
	@FXML private TextField txtRaum;    
	@FXML private DatePicker txtTerminAnf;
	@FXML private DatePicker txtTerminEnd;
	@FXML private TextField txtAufgabe;
	@FXML private TextField txtBemerkung;
	@FXML private TextField txtPlan;
	@FXML private ComboBox comboTech;
	@FXML private ComboBox comboAbr;
	@FXML private Button saveAuftrag;
	@FXML private Label searchAuftragLabel;
               
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/auftrag.fxml"));
		root.getStyleClass().add("formPane");
		this.toggleVisibility(root, false);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	/**
	 * 
	 * @param root
	 * @param show 
	 */
	private void toggleVisibility(Parent root, boolean show) {
		root.getChildrenUnmodifiable().forEach((Node n) -> {
			if (
				n instanceof Node && (
					(! this.isNew && ! this.showOnStartNotNewAufgrag.contains(n.getId()))
					|| (this.isNew && this.hideOnStartNewAufgrag.contains(n.getId()))
				)
			) {
				n.setVisible(show);
			}
		});
	}
	
	/**
	 * action bei maus click
	 *
	 * @param event
	 */
	@FXML
	protected void searchAuftragMouseClick(MouseEvent event) throws SQLException, ClassNotFoundException {
		this.findAuftraege(this.searchAuftrag.getCharacters().toString());
	}

	/**
	 * action bei taste los lässt
	 *
	 * @param event
	 */
	@FXML
	protected void searchAuftragKeyReleased(KeyEvent event) throws SQLException, ClassNotFoundException {
		if (event.getCode() == KeyCode.ENTER) {
			this.findAuftraege(this.searchAuftrag.getCharacters().toString());
		}
	}

	/**
	 * finde aufträge
	 *
	 * @param searchValue
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	private void findAuftraege(String searchValue) throws SQLException, ClassNotFoundException {
		this.searchAuftrag.setDisable(true);
		try {
			ArrayList<String> res = new ArrayList();
			demoproject.finder.Auftrag aFinder = new Auftrag();
			res = aFinder.findAutraege(searchValue);
			this.newAuftrag.setText(res.get(0));
			this.txtStrasse.setText(res.get(1));
			this.txtHausnr.setText(res.get(2));
			this.txtPLZ.setText(res.get(3));
			this.txtStadt.setText(res.get(4));
			this.txtBemerkung.setText(res.get(5));
			
			Parent root = (Parent) this.newAuftrag.getScene().getRoot();
			this.toggleVisibility(root, true);
			this.saveAuftrag.setVisible(false);
			this.searchAuftrag.setVisible(false);
			this.searchAuftragLabel.setVisible(false);
			
		} catch (Exception e) {
			new demoproject.Error(e.getMessage());
			System.out.println(e.getMessage());
		} finally {
			this.searchAuftrag.setDisable(false);
		}
	}
	
	/**
	 * save auftrag
	 * @return boolean
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	@FXML
	private boolean saveAuftrag(MouseEvent event) throws SQLException, ClassNotFoundException {
		boolean hasSave = false;
		try {
			demoproject.saver.SaveAufgrag aSaver = new SaveAufgrag();
			ArrayList<String> params = new ArrayList();
			params.add(0, this.newAuftrag.getCharacters().toString());
			params.add(1, this.txtStrasse.getCharacters().toString());
			params.add(2, this.txtHausnr.getCharacters().toString());
			params.add(3, this.txtPLZ.getCharacters().toString());
			params.add(4, this.txtStadt.getCharacters().toString());
			params.add(5, this.txtBemerkung.getCharacters().toString());
			hasSave = aSaver.save(params);
			if (hasSave) {
				Stage stage = (Stage) this.newAuftrag.getScene().getWindow();
				stage.close();
				new demoproject.Info("Auftrag mit dem Nummer " + this.newAuftrag.getCharacters().toString() + " gespeichert");
			}
		} catch (Exception e) {
			new demoproject.Error(e.getMessage());
		}
		
		return hasSave;
	}

	/**
	 * setze ob es um den neuen Autrag handelt, oder ein neuen gemacht wird
	 *
	 * @param isNew
	 */
	public void setIsNew(boolean isNew) {
		this.isNew = isNew;
	}
}
