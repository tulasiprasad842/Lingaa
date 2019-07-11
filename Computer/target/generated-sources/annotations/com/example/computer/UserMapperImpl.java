package com.example.computer;

import com.example.computer.model.Address;
import com.example.computer.model.Employee;
import com.example.computer.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-07-11T16:09:40+0530",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public List<UserDTO> userToUserDTO(List<User> entity) {
        if ( entity == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( entity.size() );
        for ( User user : entity ) {
            list.add( userToUserDTO( user ) );
        }

        return list;
    }

    @Override
    public List<AddressDTO> addressToAddressDTO(List<Address> entity) {
        if ( entity == null ) {
            return null;
        }

        List<AddressDTO> list = new ArrayList<AddressDTO>( entity.size() );
        for ( Address address : entity ) {
            list.add( addressToAddressDTO( address ) );
        }

        return list;
    }

    @Override
    public List<EmployeeDTO> employeeToEmployeeDTO(List<Employee> employee) {
        if ( employee == null ) {
            return null;
        }

        List<EmployeeDTO> list = new ArrayList<EmployeeDTO>( employee.size() );
        for ( Employee employee1 : employee ) {
            list.add( employeeToEmployeeDTO( employee1 ) );
        }

        return list;
    }

    protected UserDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setName( user.getName() );

        return userDTO;
    }

    protected AddressDTO addressToAddressDTO(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setId( address.getId() );
        addressDTO.setPlace( address.getPlace() );

        return addressDTO;
    }

    protected EmployeeDTO employeeToEmployeeDTO(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setId( employee.getId() );
        employeeDTO.setName( employee.getName() );
        employeeDTO.setSalary( employee.getSalary() );
        employeeDTO.setAddress( addressToAddressDTO( employee.getAddress() ) );

        return employeeDTO;
    }
}
