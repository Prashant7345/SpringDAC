package com.met.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name="emp")
@XmlRootElement
public class Employee {

	@Id
	private int empno;
	private String ename;
	private int age;
	private int sal;
	private int deptno;
	private int mgr;
	
	@XmlElement
	public int getempno() {
		return empno;
	}
	public void setempno(int empno) {
		this.empno = empno;
	}
	
	@XmlElement
	public String getename() {
		return ename;
	}
	public void setename(String ename) {
		this.ename = ename;
	}
	
	@XmlElement
	public int getage() {
		return age;
	}
	public int setage(int age) {
		this.age = age;
	}
	
	@XmlElement
	public int getsal() {
		return sal;
	}
	public void setsal(int sal) {
		this.sal = sal;
	}
	
	@XmlElement
	public int getdeptno() {
		return deptno;
	}
	public void setdeptno(int deptno) {
		this.deptno = deptno;
	}
	
	@XmlElement
	public int getmgr() {
		return mgr;
	}
	public void setmgr(int mgr) {
		this.mgr = mgr;
	}
	
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + ", age=" + age + ", sal=" + sal + ", deptno=" + deptno + ", mgr=" + mgr + "]";
	}
	
	
	
}
