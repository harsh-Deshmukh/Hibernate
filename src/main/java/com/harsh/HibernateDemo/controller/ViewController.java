/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.harsh.HibernateDemo.controller;


import com.harsh.HibernateDemo.model.EmployeeEntity;
import com.harsh.HibernateDemo.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 *
 * @author harshal.deshmukh
 */
@Controller
public class ViewController {

    @Autowired
    EmployeeService service;

    @GetMapping("/add")
    public String addEmployee(Model model) {
        System.out.println("Returnoing add pages");
        model.addAttribute("employee", new EmployeeEntity());
        return "add-edit-employee.html";
    }

    @GetMapping("/edit")
    public String listEmployee(Model model) {
    List<EmployeeEntity> list = service.getAllEmployee();
        model.addAttribute("employees", list);
        return "list-employees.html";
    }
@GetMapping("/delete/{id}")
public String deleteDept(@PathVariable("id") Long id,Model model){
    service.deleteEmp(id);
    System.out.println("Deleteing id");
    List<EmployeeEntity> list = service.getAllEmployee();
        model.addAttribute("employees", list);
        return "list-employees.html";
}
@GetMapping("/edit/{id}")
public String editDepartment(@PathVariable("id") Long id,Model model){
    System.out.println("editing id");
    
     return "list-employees.html";
}
    
}
