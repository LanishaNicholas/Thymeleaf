package com.example.Thymeleaf.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.Thymeleaf.Model.Employee;
import com.example.Thymeleaf.Repository.EmpRepository;
import com.example.Thymeleaf.Repository.PageAndSortExp;

@Service
public class EmpService {
	@Autowired
	private EmpRepository repository;
	@Autowired
	private PageAndSortExp pageAndSortExp;
	
	public void insertDate(Employee employee) {
		repository.save(employee);
	}
	
	public Employee getEmployee(String name) {
		return repository.findByEmpname(name);
	}
	
	public Page<Employee>findUser(String name,int page,int size){
		Pageable pageable = PageRequest.of(page, size,Sort.by(Sort.Direction.ASC, "empname"));
		return pageAndSortExp.findByEmpnameContaining(name,pageable);
	}
	
}
