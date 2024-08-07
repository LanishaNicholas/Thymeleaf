package com.example.Thymeleaf.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Thymeleaf.Model.Employee;
import com.example.Thymeleaf.Service.EmpService;

@Controller
public class EmployeeController {
	@Autowired
	EmpService service;
	
	@RequestMapping("add")
	public String addEmployee(Model model) {
		model.addAttribute("emp",new Employee());
		return "newemployee";
	}
	
	@PostMapping("send")
	public String send(@ModelAttribute("emp") Employee employee,Model model) {
		service.insertDate(employee);
		model.addAttribute("message","Employee added sucessfully");
		return "sucess";
	}
	
	@RequestMapping("viewdata")
	public String viewdata(Model model) {
		model.addAttribute("employee", service.getEmployee("anu"));
		return "ViewData";
	}
	
	@GetMapping("employees")
	public String viewEmployee(@RequestParam(name="empname",defaultValue="")String empname,
			@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="6")int size,Model model) {
		Page<Employee>employee=service.findUser(empname, page, size);
		model.addAttribute("emp",employee);
		return "ViewEmployee";
	}
}
