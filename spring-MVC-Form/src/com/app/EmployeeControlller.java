package com.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeControlller {

	@RequestMapping("/empform")
	public ModelAndView showForm() {
		System.out.println("EMPFORM////");
		return new ModelAndView("empform","command", new Employee());
	}
	
	@RequestMapping(value="/save", method= RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("emp")	Employee employee) {
		System.out.println("SAVE////");
		return new ModelAndView("reidrect:/viewemp");
	}
	
    @RequestMapping("/viewemp")  
    public ModelAndView viewemp(){  
        //write the code to get all employees from DAO  
        //here, we are writing manual code of list for easy understanding  
    	System.out.println("EMP////");
    	
    	List<Employee> list=new ArrayList<>();  
        list.add(new Employee(1,"rahul",35000f,"S.Engineer"));  
        list.add(new Employee(2,"aditya",25000f,"IT Manager"));  
        list.add(new Employee(3,"sachin",55000f,"Care Taker"));  
          
        return new ModelAndView("viewemp","list",list);  
    }  
}
