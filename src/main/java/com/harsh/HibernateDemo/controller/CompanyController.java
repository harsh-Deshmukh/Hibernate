/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.harsh.HibernateDemo.controller;

import com.harsh.HibernateDemo.model.EmployeeEntity;
import com.harsh.HibernateDemo.service.EmployeeService;
import java.net.http.HttpResponse;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author harshal.deshmukh
 */
@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(produces ={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<EmployeeEntity>> getAllDepartment() {

        return new ResponseEntity<List<EmployeeEntity>>(employeeService.getAllEmployee(), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(name="/{id}",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<EmployeeEntity> getByDeptId(@PathVariable("id") Long id) {

        return new ResponseEntity<EmployeeEntity>(employeeService.getById(id), new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/employee")
    public ModelAndView createEmployee(EmployeeEntity departmentEntity,HttpServletResponse response) {
        employeeService.empSaveOrUpdate(departmentEntity);
        
        ModelAndView model=new ModelAndView();
        List<EmployeeEntity> list=employeeService.getAllEmployee();
        System.out.println("Showing list==>"+list);
        model.addObject(list);
        model.setViewName("list-employees.html");
        return model;
      //  return new ResponseEntity<EmployeeEntity>(employeeService.empSaveOrUpdate(departmentEntity), new HttpHeaders(), HttpStatus.OK);
    }
}
