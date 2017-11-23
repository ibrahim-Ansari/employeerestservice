package com.employee.service.model;

import java.util.Date;

/***
 * Model class for user_details table in the DB.
 * @author Ibrahim 
 */
public class Employee {

	private int id;
	private String firstName;
	private String lastName;
	private Date lastmodifiedstamp;

	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getLastmodifiedstamp() {
		return lastmodifiedstamp;
	}

	public void setLastmodifiedstamp(Date lastmodifiedstamp) {
		this.lastmodifiedstamp = lastmodifiedstamp;
	}

}