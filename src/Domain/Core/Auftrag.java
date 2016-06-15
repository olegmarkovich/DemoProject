/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.Core;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Persistence;
import javax.persistence.Table;
import org.eclipse.persistence.internal.jpa.EntityManagerFactoryImpl;

/**
 *
 * @author macbookoleg
 */
@Entity
@Table(name="TBL_JOB")

public class Auftrag {
	
	private static final String PERSISTENCE_UNIT_NAME = "Auftrag";
	private static EntityManagerFactoryImpl factory;
	/**
	 *
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@Column(name="JOB_NUMBER")
	public String jobNumber;
//	int jobCustomerAddress;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "JOB_ADDRESS_ID", nullable = true)
	Address jobAddress;
//	String jobStartDate;
//	String jobEndDate;
//	int jobPerType;
	
	@Column(name = "NOTE")
	public String note;
//	String jobDescription;
//	String planing;
//	int employeePull;
//	int billingCategory;
	
	/***************** public functions *************************/
	
	/**
	 * 
	 * @param address
	 * @return 
	 */
	public Auftrag setJobAddress(Address address)
	{
		this.jobAddress = address;
		return this;
	}
	
	/**
	 * 
	 * @return 
	 */
	public Address getJobAddress()
	{
		return this.jobAddress;
	}
	
	public boolean save()
	{
		boolean result = false;
		factory = (EntityManagerFactoryImpl) Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(this);
			em.flush();
			result = true;
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			new demoproject.Error(e.getMessage());
			result = false;
			throw new Exception(e.getMessage());
		} finally {
			return result;
		}
	}
}
