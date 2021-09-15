package com.bridgelabz.employee.dto;

public class EmployeeDTO 
{
	private String name;
	private double salary;
	private String notes;

	public EmployeeDTO()
	{
		
	}

	public EmployeeDTO(String name, double salary, String notes) {
		super();
		this.name = name;
		this.salary = salary;
		this.notes = notes;
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
