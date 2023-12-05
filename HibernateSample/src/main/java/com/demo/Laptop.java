package com.demo;

import java.util.List;

/*import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;*/

import javax.persistence.*;
@Entity
public class Laptop {
	@Id
	private int lId;
	private String lname;
	@ManyToOne
	private Student student; 
	
	  public Student getStudent() { return student; } public void
	  setStudent(Student student) { this.student = student; }
	 
	public int getlId() {
		return lId;
	}
	public void setlId(int lId) {
		this.lId = lId;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}

}
