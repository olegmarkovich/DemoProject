/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.Core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author macbookoleg
 */
@Entity
@Table(name="TBL_JOB")

public class Auftrag {

	/**
	 *
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@Column(name="JOB_NUMBER")
	public String jobNumber;
//	int jobCustomerAddress;
	
	@OneToOne
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
}
