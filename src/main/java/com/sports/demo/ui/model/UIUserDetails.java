/**
 * 
 */
package com.sports.demo.ui.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/**
 * @author sudhanshu
 *
 */
public class UIUserDetails {
	
	private IntegerProperty id;
	private StringProperty name;
	private StringProperty password;
	private StringProperty country;
	
	
	
	
	
	/**
	 * @param id
	 * @param name
	 * @param password
	 */
	public UIUserDetails(IntegerProperty id, StringProperty name, StringProperty password,StringProperty country) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.country=country;
	}

	/**
	 * Id property.
	 *
	 * @return the integer property
	 */
	public final IntegerProperty idProperty() {
		return this.id;
	}
	
	public final int getId() {
		return this.idProperty().get();
	}
	
	public final void setId(final int id) {
		this.idProperty().set(id);
	}
	
	public final StringProperty nameProperty() {
		return this.name;
	}
	
	public final String getName() {
		return this.nameProperty().get();
	}
	
	public final void setName(final String name) {
		this.nameProperty().set(name);
	}
	
	public final StringProperty passwordProperty() {
		return this.password;
	}
	
	public final String getPassword() {
		return this.passwordProperty().get();
	}
	
	public final void setPassword(final String password) {
		this.passwordProperty().set(password);
	}

	public final StringProperty countryProperty() {
		return this.country;
	}
	

	public final String getCountry() {
		return this.countryProperty().get();
	}
	

	public final void setCountry(final String country) {
		this.countryProperty().set(country);
	}
	
	

	
	
	
}
