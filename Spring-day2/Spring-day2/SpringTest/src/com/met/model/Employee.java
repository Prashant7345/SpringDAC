package com.met.model;

public class Employee {

	private static int count = 0;
	
	private int id;
	private String name;
	private int age;
	private String designation;
	private double salary;
	
	private Address address;
	
	public Employee() {
		id = ++count;
		System.out.println("Default Employee object created with id: " + id);
	}
	
	public Employee(String name, int age){
		//id = ++count;
		this();
		this.name = name;
		this.age = age;
		designation = "FRESHER";
		salary = 35000;
		System.out.println("Parameterized employee object created with id... " + id);
	}
	
	

	public Employee(String name, int age, String designation, double salary, Address address) {
		this();
		this.name = name;
		this.age = age;
		this.designation = designation;
		this.salary = salary;
		this.address = address;
		
		System.out.println("Parameterized const with all fields...........");
	}

	/*@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", designation=" + designation + ", salary="
				+ salary + "]";
	}*/
	
	

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", designation=" + designation + ", salary="
				+ salary + ", address=" + address + "]";
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
}
