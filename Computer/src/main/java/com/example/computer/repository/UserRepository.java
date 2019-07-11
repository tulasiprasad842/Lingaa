/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.computer.repository;

/**
 *
 * @author Linga357
 */
import com.example.computer.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public void saveUserInDB(User user) {
        entityManager.persist(user);

    }

    public User getUserById(int id) {
        TypedQuery<User> typedQuery = entityManager.createNamedQuery("User.findById", User.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult();

    }

    public List<User> getUser() {
        try {
            TypedQuery<User> typedQuery = entityManager.createNamedQuery("User.findAll", User.class);
            return typedQuery.getResultList();
        } catch (Exception e) {
            System.out.println("========>" + e.getMessage());
            return new ArrayList<>();
        }

    }

}
