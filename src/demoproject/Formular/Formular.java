/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoproject.Formular;

import javafx.stage.Stage;

/**
 *
 * @author Lenovo
 */
public interface Formular {

    /**
     *
     * @param primaryStage
     * @param formTitle
     */
    abstract public void show(Stage primaryStage, String formTitle);
    
    abstract public void hide();
}