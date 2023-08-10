package com.employeeapplication.empapp.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDTO {

	    private String name;
		private String gender;
		private Date startdate;
		private long salary;
		private String profilepic;
		private List<String> department;
		private String note;
}
