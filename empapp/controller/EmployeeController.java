package com.employeeapplication.empapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeeapplication.empapp.dto.EmployeeDTO;
import com.employeeapplication.empapp.model.EmployeeModel;
import com.employeeapplication.empapp.service.EmployeeInterface;


@RestController
public class EmployeeController {

	@Autowired
	EmployeeInterface service;
	
	@PostMapping("/insert")
	public ResponseEntity<EmployeeModel> insertingEmployee(@RequestBody EmployeeDTO model)
	{
		EmployeeModel user = service.addingEmployee(model);
		return new ResponseEntity<EmployeeModel>(user,HttpStatus.CREATED);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeModel>> getAllEmployee()
	{
		List<EmployeeModel> allEmployee = service.displayAllEmployee();
		return new ResponseEntity<List<EmployeeModel>>(allEmployee,HttpStatus.OK);
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<EmployeeModel> getEmployeeById(@PathVariable int id) {
		EmployeeModel searchById = service.getEmpById(id);
		return new ResponseEntity<EmployeeModel>(searchById,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int id)
	{
		String delete = service.deleteEmployee(id);
		return new ResponseEntity<String>(delete,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updateById/{id}")
	public  ResponseEntity<EmployeeModel> updateEmployeeById(@PathVariable int id, @RequestBody EmployeeDTO model)
	{
		EmployeeModel user = service.updateById(id, model);
		return new ResponseEntity<EmployeeModel>(user,HttpStatus.ACCEPTED);
	}
	
	
	
}
