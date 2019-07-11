/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.computer.controller;

/**
 *
 * @author Linga357
 */

import com.example.computer.AddressDTO;
import com.example.computer.UserMapper;
import com.example.computer.model.Address;
import com.example.computer.repository.AddressRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class AddressController {
   
    
    @Autowired
    AddressRepository studentRepository;
        @GetMapping(path = "/get", produces = {"applcation/json", "application/xml"})
    public ResponseEntity<List<AddressDTO>> getUserDetail() {
        try {
            List<Address> address
                    = studentRepository.getAddress();
            List< AddressDTO> temp = UserMapper.INSTANCE.addressToAddressDTO(address);
            return ResponseEntity.status(HttpStatus.OK).body(temp);
        } catch (Exception e) {
            System.out.println("============>" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());

        }

    }

}
