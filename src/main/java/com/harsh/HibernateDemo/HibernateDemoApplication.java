package com.harsh.HibernateDemo;

import com.harsh.HibernateDemo.model.BankAccount;
import com.harsh.HibernateDemo.model.DepartmentEntity;
import com.harsh.HibernateDemo.model.EmployeeEntity;
import com.harsh.HibernateDemo.repository.EmployeeRepository;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateDemoApplication implements CommandLineRunner {

    @Autowired
    EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(HibernateDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setFirstName("Tanaji");
        employeeEntity.setEmail("Tanaji@gmail.com");
        employeeEntity.setLastName("Malusare");

        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setDeptName("Computer");

        System.out.println("Setting Department details...");
        employeeEntity.setDepartmentEntity(departmentEntity);

        System.out.println("Setting Bank Account details...");

        Set<BankAccount> set = new HashSet<BankAccount>();
        set.add(new BankAccount("Saving"));
        set.add(new BankAccount("Current"));
        set.add(new BankAccount("Loan Account"));

        employeeEntity.setBankAccounts(set);

        employeeRepository.save(employeeEntity);
        System.out.println("record saved........");

//System.out.println("Data "+employeeRepository.findById(200l));
    }
}
