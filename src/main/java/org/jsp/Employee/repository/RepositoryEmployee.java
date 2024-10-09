package org.jsp.Employee.repository;

import org.jsp.Employee.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryEmployee extends JpaRepository<Employee,Integer> {
	
}