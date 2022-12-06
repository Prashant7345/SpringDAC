package com.met.model;

public class Address {

	private static int count;
	
	private String id;
	private String city;
	private String country;
	
	public Address(){
		id = "A" + ++count;
		System.out.println("Default Address object created with id: " + id);
	}
	
	public Address(String city, String country){
		
		this();
		this.city = city;
		this.country = country;
		System.out.println("Parameterized Address object created...");
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", country=" + country + "]";
	}
	
}
