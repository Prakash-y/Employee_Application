package com.employeeapplication.empapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeapplication.empapp.model.EmployeeModel;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Integer> {

}
