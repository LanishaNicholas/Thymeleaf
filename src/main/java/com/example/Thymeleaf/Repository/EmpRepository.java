package com.example.Thymeleaf.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.Thymeleaf.Model.Employee;

public interface EmpRepository extends CrudRepository<Employee,Integer>{
	public Employee findByEmpname(String name);
}
