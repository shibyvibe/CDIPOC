package com.restfully.shop.CDIPOC;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

public class Item {
	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return String.valueOf(this.hashCode());
		
	}

	private String productCode;
	
}
