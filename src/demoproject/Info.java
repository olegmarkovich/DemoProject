/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoproject;

import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author Lenovo
 */
public class Info extends Application{
    private final String msg;
    
    private void show() {
        Platform.runLater(() -> {
            try {
                Alert alert;
                alert = new Alert(Alert.AlertType.INFORMATION);
                ButtonType btnOK = new ButtonType("OK", ButtonBar.ButtonData.CANCEL_CLOSE);
                alert.setTitle("Info");
                alert.setContentText(msg);
                alert.getButtonTypes().setAll(btnOK);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == btnOK) {
                    alert.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
      );
    }

    public Info() {
        this.msg = "Wrong call";
        Info info = new Info(msg);
    }
    
    public Info(String msg) {
        this.msg = msg;
        this.show();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
