package com.example.Thymeleaf.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.Thymeleaf.Model.Employee;

public interface PageAndSortExp extends PagingAndSortingRepository<Employee, Integer> {
	Page<Employee>findByEmpnameContaining(String name,Pageable pageable);
}
