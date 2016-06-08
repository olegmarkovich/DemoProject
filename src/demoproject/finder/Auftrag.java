/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoproject.finder;

import demoproject.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author macbookoleg
 */
public class Auftrag extends DBConnect {

	/**
	 *
	 * @param searchVal
	 * @return
	 */
	public ArrayList findAutraege(String searchVal) throws SQLException, ClassNotFoundException {
		Connection conn = this.getConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tbl_auftrag WHERE UPPER(number) LIKE UPPER(?)");

		stmt.setString(1, '%' + searchVal + '%');
		ResultSet rs;
		rs = stmt.executeQuery();
		ArrayList<String> list = new ArrayList();
		while (rs.next()) {
			String number = rs.getString("number");
			list.add(number);
		}
		
		conn.close();
		
		if (list.isEmpty()) {
			new demoproject.Error("Aufgrag nicht existiert");
		}
		
		return list;
	}
}
