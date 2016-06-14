/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.Core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author macbookoleg
 */
@Entity
@Table(name="TBL_COUNTRY")
public class Country {
	@Id
	@Column(name="ISO2CODE")
	public String iso2code;
	
	@Column(name="COUNTRY_NAME")
	public String countryName;
	
	@Column(name="CURRENCY_SYMBOL")
	public String currencySymbol;
	
	@Column(name="CURRENCY_ISO3CODE")
	public String currencyIso3Code;
}
