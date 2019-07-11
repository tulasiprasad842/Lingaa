/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.computer.controller;

import com.example.computer.EmployeeDTO;
import com.example.computer.UserMapper;
import com.example.computer.model.Address;
import com.example.computer.model.Employee;

import com.example.computer.repository.EmployeeRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Linga357
 */
@RestController

public class EmployeeController {

    @Autowired
    EmployeeRepository studentRepository;

    @GetMapping(path = "/getemp", produces = {"applcation/json", "application/xml"})
    public ResponseEntity<List<EmployeeDTO>> getUserDetail() {
        try {
            List<Employee> employee = studentRepository.getAddress();

            List< EmployeeDTO> temp = UserMapper.INSTANCE.employeeToEmployeeDTO(employee);
            return ResponseEntity.status(HttpStatus.OK).body(temp);
        } catch (Exception e) {
            System.out.println("============>" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());

        }
    }
}
