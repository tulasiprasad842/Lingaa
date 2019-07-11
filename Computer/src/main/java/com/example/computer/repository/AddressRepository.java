/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.computer.repository;

import com.example.computer.model.Address;
import com.example.computer.model.User;
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

public class AddressRepository {

    @Autowired
    EntityManager entityManager;

    public List<Address> getAddress() {
        try {
            TypedQuery<Address> typedQuery = entityManager.createNamedQuery("User.findAll", Address.class);
            return typedQuery.getResultList();
        } catch (Exception e) {
            System.out.println("========>" + e.getMessage());
            return new ArrayList<>();
        }
    }

}
