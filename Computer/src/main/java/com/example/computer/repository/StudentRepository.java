/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.computer.repository;

import com.example.computer.model.Student;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.constraints.AssertFalse.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class StudentRepository {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public void saveStudentInDB(Student student) {
        entityManager.persist(student);

    }

    public Student getStudentById(int id) {
        TypedQuery<Student> typedQuery = entityManager.createNamedQuery("Student.findById", Student.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult();

    }
}
