/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoproject.finder;

import demoproject.DBConnect;
import java.util.Vector;

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
	 * @throws NoResultException 
	 */
	public Vector findAutraege(String searchVal) throws NoResultException {
		factory = (EntityManagerFactoryImpl) Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		Query q = em.createQuery("SELECT a FROM Auftrag a WHERE UPPER(a.jobNumber) LIKE UPPER(:searchVal)");
		q.setParameter("searchVal", "%" + searchVal + "%");
		Vector<Domain.Core.Auftrag> list = new Vector<Domain.Core.Auftrag>();
		try {
			list = (Vector<Domain.Core.Auftrag>) q.getResultList();
			list.forEach((Domain.Core.Auftrag a) -> {
				System.out.println(a.getJobAddress().getCountry().iso2code);
			}) ;
		} catch (NoResultException nre) {
			System.out.println(q.getParameter("searchVal"));
		}
		
		return list;
	}
}
