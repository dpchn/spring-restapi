package com;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class Student extends AbstractController{

	private String name;
	private int age;
	private String email;

	public Student() {

	}

	public Student(String name, int age, String branch) {
		this.name = name;
		this.age = age;
		this.email = branch;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBranch() {
		return email;
	}

	public void setBranch(String branch) {
		this.email = branch;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("Hello");
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("name", getName());
		mv.addObject("age", getAge());
		mv.addObject("email", getBranch());
		return mv;

	}

}