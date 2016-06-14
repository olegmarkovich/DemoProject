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
	String jobNumber;
//	int jobCustomerAddress;
//	int jobAddress;
//	String jobStartDate;
//	String jobEndDate;
//	int jobPerType;
//	String note;
//	String jobDescription;
//	String planing;
//	int employeePull;
//	int billingCategory;
}
