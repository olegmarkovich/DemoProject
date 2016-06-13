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

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.eclipse.persistence.internal.jpa.EntityManagerFactoryImpl;

/**
 *
 * @author macbookoleg
 */
public class Auftrag extends DBConnect {
	
	private static final String PERSISTENCE_UNIT_NAME = "Auftrag";
	private static EntityManagerFactoryImpl factory;
	/**
	 *
	 * @param searchVal
	 * @return
	 * @throws java.sql.SQLException
	 * @throws java.lang.ClassNotFoundException
	 */
	public ArrayList findAutraege(String searchVal) throws SQLException, ClassNotFoundException {
		factory = (EntityManagerFactoryImpl) Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		Query q = em.createQuery("SELECT a FROM Auftrag a WHERE UPPER(a.jobNumber) LIKE UPPER(:searchVal)");
		q.setParameter("searchVal", "%" + searchVal + "%");
		System.out.println(q.toString());
		try {
			Domain.Core.Auftrag auftrag = (Domain.Core.Auftrag) q.getSingleResult();
			System.out.println(auftrag);
		} catch (NoResultException nre) {
			System.out.println(q.getParameter("searchVal"));
		}
		
		
		
		Connection conn = this.getConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT "
				+ " j.job_number, a.street_1, a.home_number, a.zip_code, a.city, j.note "
				+ " FROM tbl_job AS j "
				+ " LEFT JOIN tbl_address AS a ON j.job_address_id = a.id "
				+ " WHERE UPPER(j.job_number) LIKE UPPER(?)");

		stmt.setString(1, '%' + searchVal + '%');
		ResultSet rs;
		rs = stmt.executeQuery();
		ArrayList<String> list = new ArrayList();
		while (rs.next()) {
			list.add(0, rs.getString("job_number"));
			list.add(1, rs.getString("street_1"));
			list.add(2, rs.getString("home_number"));
			list.add(3, rs.getString("zip_code"));
			list.add(4, rs.getString("city"));
			list.add(5, rs.getString("note"));
		}
		
		conn.close();
		
		if (list.isEmpty()) {
			new demoproject.Error("Aufgrag nicht existiert");
		}
		
		return list;
	}
}
