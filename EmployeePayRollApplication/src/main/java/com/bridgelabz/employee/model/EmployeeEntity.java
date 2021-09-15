package com.bridgelabz.employee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.employee.dto.EmployeeDTO;

@Entity
@Table(name = "employee_tbl")
public class EmployeeEntity 
{
	@Id
	@GeneratedValue()
	private int id;
	private String name;
	private double salary;
	private String notes;
	
	public EmployeeEntity()
	{
		
	}

	public EmployeeEntity(EmployeeDTO dto) 
	{
		super();
		this.name = dto.getName();
		this.salary = dto.getSalary();
		this.notes = dto.getNotes();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
}
