/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.computer.repository;

import com.example.computer.model.Address;
import com.example.computer.model.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Linga357
 */
@Repository
public class EmployeeRepository {

    @Autowired
    EntityManager entityManager;

    public List<Employee> getAddress() {
        try {
            TypedQuery<Employee> typedQuery = entityManager.createNamedQuery("Employee.findAll", Employee.class);
            return typedQuery.getResultList();
        } catch (Exception e) {
            System.out.println("========>" + e.getMessage());
            return new ArrayList<>();
        }
    }

//    public void getEmployee() {
//         "SELECT e FROM Employee e";
//        
//        
//    }
}
