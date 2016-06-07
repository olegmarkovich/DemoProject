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
public class KundenController extends Application {
                
    private boolean isNew;
    
    /**
	 *
	 * @param event
	 */
    
    @Override
    public void start(Stage primaryStage) throws Exception 
    {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }
    
	public void setIsNew(boolean isNew)
	{
		this.isNew = isNew;
	}
}
