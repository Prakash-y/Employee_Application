package com.employeeapplication.empapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeapplication.empapp.dto.EmployeeDTO;
import com.employeeapplication.empapp.model.EmployeeModel;
import com.employeeapplication.empapp.repository.EmployeeRepository;

@Service
public class EmployeeService implements EmployeeInterface{

	@Autowired
	 private EmployeeRepository employeeRepository;
	
	
	@Override
	public EmployeeModel addingEmployee(EmployeeDTO model) {
		EmployeeModel user = new EmployeeModel(model);
		employeeRepository.save(user);
		return user;
	}

	@Override
	public List<EmployeeModel> displayAllEmployee() {
		return employeeRepository.findAll();
		
	}

	@Override
	public EmployeeModel getEmpById(int id) {
		Optional<EmployeeModel> user = employeeRepository.findById(id);
		return user.get();
	}

	@Override
	public String deleteEmployee(int id) {
		employeeRepository.deleteById(id);
		return "Deleted Succefully..!";
	}

	@Override
	public EmployeeModel updateById(int id, EmployeeDTO model) {
		EmployeeModel empModel = employeeRepository.findById(id).get();
		empModel.setName(model.getName());
		empModel.setGender(model.getGender());
		empModel.setStartdate(model.getStartdate());
		empModel.setSalary(model.getSalary());
		empModel.setProfilepic(model.getProfilepic());
		empModel.setDepartment(model.getDepartment());
		empModel.setNote(model.getNote());
		employeeRepository.save(empModel);
		
		return empModel;
	}

	
}
