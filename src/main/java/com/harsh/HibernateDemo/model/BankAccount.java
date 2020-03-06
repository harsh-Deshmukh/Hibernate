/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.harsh.HibernateDemo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ManyToAny;

/**
 *
 * @author harshal.deshmukh
 */
@Entity(name = "BankAccount")
@XmlRootElement
public class BankAccount implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long acount_no;

    @Override
    public String toString() {
        return "BankAccount{" + "acount_no=" + acount_no + ", accountType=" + accountType + ", employeeEntity=" + employeeEntity + '}';
    }
    
    @Column(name="account_type")
    private String accountType;
    
    
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("bankAccounts")
   private EmployeeEntity employeeEntity;

    public long getAcount_no() {
        return acount_no;
    }

    public void setAcount_no(long acount_no) {
        this.acount_no = acount_no;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }
    public BankAccount(){
        
    }
    
     public BankAccount(String accountType){
        this.accountType=accountType;
    }
    
}
