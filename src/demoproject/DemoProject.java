/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoproject;

import demoproject.Formular.Auftrag;
import demoproject.Formular.AuftragController;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Lenovo
 */
public class DemoProject extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        MenuBar menuBar = new MenuBar();
        BackgroundFill menuBarBgFill = new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY);
        menuBar.setBackground(new Background(menuBarBgFill));
        
        
        Menu menuFile = new Menu("Datei");
        
        
        MenuItem newAuftrag = new MenuItem("Neu Auftrag");
        newAuftrag.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AuftragController auftragController = new AuftragController();
                try {
                    auftragController.setIsNew(true);
                    auftragController.start(primaryStage);
                } catch (Exception ex) {
                    Logger.getLogger(DemoProject.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        MenuItem searchAuftrag = new MenuItem("Suchen Auftrag");
        searchAuftrag.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AuftragController auftragController = new AuftragController();
                try {
                    auftragController.setIsNew(false);
                    auftragController.start(primaryStage);
                } catch (Exception ex) {
                    Logger.getLogger(DemoProject.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        MenuItem exit = new MenuItem("Schliessen");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        
        
        menuFile.getItems().addAll(newAuftrag, searchAuftrag, exit);
        
        Menu menuEdit = new Menu("Bearbeiten");
        menuEdit.setDisable(true);
        menuBar.getMenus().addAll(menuFile, menuEdit);
        
        StackPane root = new StackPane();
        root.setAlignment(Pos.TOP_LEFT);
        root.setMinWidth(800);
        root.getChildren().addAll(menuBar);
        
        Scene scene = new Scene(root, 800, 600);
        
        primaryStage.setTitle("TP-Networks");
        primaryStage.setScene(scene);
        primaryStage.show();
//        new Auftrag(primaryStage, true);
    }

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        DBConnect myDb = new DBConnect();
        Connection conn = myDb.getConnection();
        if (conn != null) {
             launch(args);
        }
    }
}
