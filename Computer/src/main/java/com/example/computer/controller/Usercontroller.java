/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.computer.controller;

import com.example.computer.UserDTO;
import com.example.computer.UserMapper;
import com.example.computer.model.User;
import com.example.computer.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
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
 * @author Linga357
 */
@RestController
//@RequestMapping("/api")

public class Usercontroller {

    @Autowired
    UserRepository studentRepository;

    @PostMapping(path = "/user", produces = {"application/json", "application/xml"})
    public void saveUserDetaials(@RequestBody User user) {
        studentRepository.saveUserInDB(user);

    }

    @GetMapping(path = "/{id}/user", produces = {"applcation/json", "application/xml"})
    public ResponseEntity<User> getUserDetails(@PathVariable("id") int id) {
        User user = studentRepository.getUserById(id);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(user);

    }

    @GetMapping(path = "/getusers", produces = {"applcation/json", "application/xml"})
    public ResponseEntity<List<UserDTO>> getUserDetail() {
        try {
            List<User> user
                    = studentRepository.getUser();
            List< UserDTO> temp = UserMapper.INSTANCE.userToUserDTO(user);
            return ResponseEntity.status(HttpStatus.OK).body(temp);
        } catch (Exception e) {
            System.out.println("============>" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());

        }

    }
}
