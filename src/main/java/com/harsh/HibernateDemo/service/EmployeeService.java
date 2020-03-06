/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.harsh.HibernateDemo.service;

import com.harsh.HibernateDemo.model.EmployeeEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.harsh.HibernateDemo.repository.EmployeeRepository;

/**
 *
 * @author harshal.deshmukh
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository departmentRepository;

    public List<EmployeeEntity> getAllEmployee() {
        List<EmployeeEntity> deptList = departmentRepository.findAll();
        if (deptList.size() > 0) {
            
            return deptList;
        } else {
            return new ArrayList<EmployeeEntity>();
        }
    }

    public EmployeeEntity getById(Long deptid) {
        Optional<EmployeeEntity> optional = departmentRepository.findById(deptid);
        if (optional.isPresent()) {
            System.out.println("Size==>"+optional.get());
            return optional.get();
        } else {
            return new EmployeeEntity();
        }
    }

    public EmployeeEntity empSaveOrUpdate(EmployeeEntity entity) {
        if (entity.getEmp_id() == null) {
            System.out.println("Yes! Its new record"+entity.getDepartmentEntity().getDeptName());
            return departmentRepository.save(entity);
        }
        Optional<EmployeeEntity> optional = departmentRepository.findById(entity.getEmp_id());

        if (optional.isPresent()) {
            EmployeeEntity old = optional.get();
            old.setEmail(entity.getEmail());
            old.setFirstName(entity.getFirstName());
            old.setLastName(entity.getLastName());
            return departmentRepository.save(old);
        }
        return departmentRepository.save(entity);
    }

    public void deleteEmp(Long id) {
       departmentRepository.deleteById(id);
    }

}
