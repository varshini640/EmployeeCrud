package org.jsp.Employee.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Employee {

	@GeneratedValue
	@Id
	private int id;
	private String name;
	private String email;
	private String gender;
	private long mobile;
	private double salary;
}
