/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.harsh.HibernateDemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author harshal.deshmukh
 */
@Entity
@Table(name = "EMPLOYEE", uniqueConstraints = {
    @UniqueConstraint(columnNames = "emp_id"),
    @UniqueConstraint(columnNames = "email")})
@JsonRootName(value = "Employee")
@XmlRootElement
public class EmployeeEntity implements Serializable {

    public EmployeeEntity() {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emp_id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", nullable = false, length = 200)
    private String email;

    
     //1st way by foreign key in owner table of child table
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dept_Id")
    @JsonIgnoreProperties("employeeEntity")
    private DepartmentEntity departmentEntity;

    //2nd Way  1 to 1 by creating 3rd table and mainting primary key valu of both by using @JoinTable(..)
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinTable(name = "Employee_Department" ,joinColumns = @JoinColumn(name = "emp_id"),inverseJoinColumns = @JoinColumn(name = "dept_id"))
//    private DepartmentEntity departmentEntity;
    
    
    // 3rd way  1 to 1 by sharing primary key of owner as PK of child table 
//    @OneToOne(cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    private DepartmentEntity departmentEntity;
    
   
    
    // 1st way og 1 To M realtionship by making PK of Employee to FK of BankAccount table
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id")
    @JsonIgnoreProperties("employeeEntity")
    private Set<BankAccount> bankAccounts;
    
    
    

    public Set<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(Set<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
    
    public Long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Long emp_id) {
        this.emp_id = emp_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   
    public DepartmentEntity getDepartmentEntity() {
        return departmentEntity;
    }

    public void setDepartmentEntity(DepartmentEntity departmentEntity) {
        this.departmentEntity = departmentEntity;
    }

    @Override
    public String toString() {
        return "EmployeeEntity [id=" + emp_id + ", firstName=" + firstName
                + ", lastName=" + lastName + ", email=" + email + departmentEntity.toString() + "]";
    }
}
