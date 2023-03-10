package edu.miu.cs.cs472.letexplore.model;

import java.io.Serializable;

final public class AddressModel  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1872328499096991882L;
	private String street;
	private String city;
	private String state;
	private String zip;
	
	public AddressModel(String street, String city, String state, String zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	public String getStreet() {
		return street;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getZip() {
		return zip;
	}
	@Override
	public String toString() {
		return "[" + street + ", " + city + ", " + state + ", " + zip + "]";
		
	}

}
