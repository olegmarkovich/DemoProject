/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoproject;

import demoproject.Formular.MenuController;
import java.sql.Connection;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Lenovo
 */
public class DemoProject extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		MenuController mController = new MenuController();
		mController.start(primaryStage);
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
