/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.harsh.HibernateDemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author harshal.deshmukh
 */
@Entity(name = "DEPARTMENT")
   @XmlRootElement
public class DepartmentEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dept_Id;

    @Override
    public String toString() {
        return "DepartmentEntity{" + "dept_Id=" + dept_Id + ", deptName=" + deptName +  '}';
    }

    @Column(name="dept_name")
    private String deptName;
    
    @OneToOne(mappedBy = "departmentEntity" ,cascade = CascadeType.ALL)
     @JsonIgnoreProperties("departmentEntity")
 
    private EmployeeEntity employeeEntity;

    public Long getDept_Id() {
        return dept_Id;
    }

    public void setDept_Id(Long dept_Id) {
        this.dept_Id = dept_Id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }
public DepartmentEntity(){
    System.out.println("calling Department consturctor...");
}
}
