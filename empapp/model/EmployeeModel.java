package com.employeeapplication.empapp.model;

import java.util.Date;
import java.util.List;

import com.employeeapplication.empapp.dto.EmployeeDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employees")
@Data
@NoArgsConstructor
public class EmployeeModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int employeeId;
    private String name;
	private String gender;
	private Date startdate;
	private long salary;
	private String profilepic;
	private List<String> department;
	private String note;
	
	public EmployeeModel(EmployeeDTO model)
	{
		
		this.name=model.getName();
		this.gender=model.getGender();
		this.startdate=model.getStartdate();
		this.salary=model.getSalary();
		this.profilepic=model.getProfilepic();
		this.department=model.getDepartment();
		this.note=model.getNote();
	}
}

