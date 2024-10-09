package org.jsp.Employee.controller;

import java.util.List;
import java.util.Optional;

import org.jsp.Employee.dto.Employee;
import org.jsp.Employee.repository.RepositoryEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.AbstractRepositoryConfigurationSourceSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MyController {

	@Autowired
	RepositoryEmployee repository;
	
	@GetMapping("/")
	public String loadHome() {		
		return "home.html";
	}
	
	@GetMapping("add-record")
	public String loadForm(ModelMap map){
		map.put("add","add");
		return "home.html";
	}
	
	@PostMapping("add-record")
	public String addRecord(Employee emp,ModelMap map) {
		repository.save(emp);
		map.put("success","Record has been Added Sucessfully!!");
		return "home.html";
	}
	
	
	@GetMapping("fetch-record")
	public String fetchRecord(ModelMap map) {
		List<Employee> emp = repository.findAll();
		map.put("employee", emp);
		map.put("fetch", "fetch");
		return "home.html";
	}
	
	@GetMapping("edit")
	public String edit(@RequestParam int id,ModelMap map)
	{
		Employee emp = repository.findById(id).orElseThrow();
		map.put("record",emp);
		map.put("edit", "edit");
		return "home.html";
		
	}
	
	@PostMapping("edit")
	public String update(Employee emp,ModelMap map)
	{
		repository.save(emp);
		map.put("success", "record Updated Successfuly");
		return "home.html";
	}
	
	@GetMapping("delete")
	public String delete(@RequestParam int id,ModelMap map)
	{
		repository.deleteById(id);
		map.put("success","record deleted successfully");
		return "home.html";
	}
	
}
