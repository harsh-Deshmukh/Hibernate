/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.harsh.HibernateDemo.repository;

import com.harsh.HibernateDemo.model.DepartmentEntity;
import com.harsh.HibernateDemo.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author harshal.deshmukh
 */
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    public void save(DepartmentEntity departmentEntity);

}
