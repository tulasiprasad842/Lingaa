/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.computer.controller;

import com.example.computer.model.Student;
import com.example.computer.repository.StudentRepository;
import javax.validation.constraints.AssertFalse.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author VMHDCLAP21
 */
@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @PostMapping(path = "/student", produces = {"application/json", "application/xml"})
    public void saveStudentDetaials(@RequestBody Student student) {
        studentRepository.saveStudentInDB(student);

    }

    @GetMapping(path = "/{id}/student", produces = {"applcation/json", "application/xml"})
    public ResponseEntity<Student> getStudentDetails(@PathVariable("id") int id) {
        Student student = studentRepository.getStudentById(id);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(student);

    }

}
