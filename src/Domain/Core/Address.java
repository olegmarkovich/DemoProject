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
@Table(name="TBL_ADDRESS")

public class Address {

	/**
	 *
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@Column(name="STREET_1")
	public String street1;
	
	@Column(name="STREET_2")
	public String street2;
	
	@Column(name="HOME_NUMBER")
	public String homeNumber;
	
	@Column(name="ZIP_CODE")
	public String zipCode;
	
	@Column(name="CITY")
	public String city;
	
	@OneToOne
	@JoinColumn(name = "COUNTRY_ISO2CODE", nullable = false)
	Country country;
	
	@Column(name="PHONE_1")
	public String phone1;
	
	@Column(name="PHONE_2")
	public String phone2;
	
	@Column(name="MOBILE_1")
	public String mobile1;
	
	@Column(name="MOBILE_2")
	public String mobile2;
	
	@Column(name="FAX_1")
	public String fax1;
	
	@Column(name="FAX_2")
	public String fax2;
	
	@Column(name="WEB_1")
	public String web1;
	
	@Column(name="WEB_2")
	public String web2;
	
	@Column(name="EMAIL_1")
	public String email1;
	
	@Column(name="EMAIL_2")
	public String email2;
	
	/***************** public functions *************************/
	
	/**
	 * 
	 * @param country
	 * @return 
	 */
	public Address setCountry(Country country)
	{
		this.country = country;
		return this;
	}
	
	/**
	 * 
	 * @return 
	 */
	public Country getCountry()
	{
		return this.country;
	}
}
