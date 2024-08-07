package com.example.Thymeleaf.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Person {
	@NotBlank(message="Name is a required field")
	@Size(min=3,message="name should contain at least 3 characters")
	@Size(max=10,message="name should not more than 10 characters")
	private String name;
	
	@NotBlank
	@Pattern(regexp="[6-9][0-9]{9}",message="enter a valid phone number")
	private String phone;
	
	@Min(10)
	@Max(28)
	private int age;
	
	@NotBlank(message="Email is a required field")
	@Email
	private String email;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
