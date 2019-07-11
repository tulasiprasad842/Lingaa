/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.computer;

import com.example.computer.model.Address;
import com.example.computer.model.Employee;
import com.example.computer.model.User;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author Linga357
 */
@Mapper(componentModel="spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    List<UserDTO> userToUserDTO(List<User> entity);
    List<AddressDTO> addressToAddressDTO(List<Address> entity);
//    List<EmployeeDTO> employeetoEmployeeDTO(List<Employee> entity);
//    public UserDTO userToUserDTO();
//    @Mappings({
//@Mapping(target="eName", source="entity.name")
//})
//EmployeeDTO employeeToEmployeeDTO(Employee entity);
//@Mappings({
//@Mapping(target="name", source="dto.employeeName")
//})
//
//Employee employeeDTOToEmployee(EmployeeDTO dto);

//    public List<AddressDTO> userToUserDTO(List<Address> address);
//

     List<EmployeeDTO> employeeToEmployeeDTO(List<Employee> employee);


   

   
    

}
