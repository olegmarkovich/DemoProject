/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoproject.saver;

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
public class SaveAufgrag extends DBConnect {

	public boolean save(ArrayList<String> data) throws SQLException, ClassNotFoundException 
	{
		boolean isSaved = false;
		Connection conn = this.getConnection();
		conn.setAutoCommit(false);
		try {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO tbl_address "
					+ "(street_1, home_number, zip_code, city, country_iso2code)"
					+ "VALUES"
					+ "(?, ?, ?, ?, 'DE')");
			stmt.setString(1, data.get(1));
			stmt.setString(2, data.get(2));
			stmt.setString(3, data.get(3));
			stmt.setString(4, data.get(4));
			stmt.execute();

			stmt = conn.prepareStatement("SELECT MAX(ID) AS ID FROM tbl_address");
			Integer addressId = null;
			ResultSet rs;
			rs = stmt.executeQuery();
			while (rs.next()) {
				addressId = rs.getInt("ID");
			}

			stmt = conn.prepareStatement("INSERT INTO tbl_job"
					+ "(job_number, job_address_id, job_start_date, note)"
					+ "VALUES"
					+ "(?,?,CURRENT_TIMESTAMP, ?)");

			stmt.setString(1, data.get(0));
			stmt.setInt(2, addressId);
			stmt.setString(3, data.get(5));
			stmt.execute();
			conn.commit();
			isSaved = true;
		} catch (Exception e) {
			conn.rollback();
			new demoproject.Error(e.getMessage());
		} finally {
			conn.setAutoCommit(true);
			conn.close();
		}
		return isSaved;
	}
}
