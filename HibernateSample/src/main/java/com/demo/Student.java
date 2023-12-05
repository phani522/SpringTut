package com.demo;

import java.util.ArrayList;
import java.util.List;

/*import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;*/
import javax.persistence.*;

@Entity
public class Student {
	@Id
	private int roll;
	private String name;
	private int marks;
	@OneToMany(mappedBy = "student")
	private List<Laptop> laptop=new ArrayList<Laptop>();
	public List<Laptop> getLaptop() {
		return laptop;
	}
	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	

}
