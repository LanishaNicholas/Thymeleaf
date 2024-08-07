package com.example.Thymeleaf.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Thymeleaf.Model.Person;
import com.example.Thymeleaf.Model.UserModel;

import jakarta.validation.Valid;

@Controller
public class ThymeleafController {
	@RequestMapping("/")
	public String index(Model model) {
		UserModel user = new UserModel();
		user.setName("Lanisha");
		user.setEmail("lanishanicholas@gmail.com");
		model.addAttribute("usermodel",user);
		return "index";
	}
	
	@RequestMapping("home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("welcome")
	public String welcome(Model model) {
		List<String>list=new ArrayList<String>(Arrays.asList("BMW","TATA","Toyotta"));
		model.addAttribute("car",list);
		String[]planets = {"Mercury","Venus","Earth","Mars","Jupeter","Saturn","Uranus","Neptune"};
		model.addAttribute("planet",planets);
		return "welcome";
	}
	
	@RequestMapping("ifelse")
	public String ifelse(Model model) {
		model.addAttribute("number",-20);
		return "ifelse";
	}
	
	@RequestMapping("switchs")
	public String switchs(Model model) {
		model.addAttribute("num",1);
		return "switchs";
	}
	
	@RequestMapping("formvalidation")
	public String formvalidation(Model model) {
		model.addAttribute("person",new Person());
		return "FormValidation";
	}
	
	@PostMapping("processForm")
	public String processForm(@Valid @ModelAttribute("person")Person person,BindingResult thebindingresult) {
		if(thebindingresult.hasErrors()) {
			return "FormValidation";
		}else {
			return "FormSucces";
		}
	}
	
}
