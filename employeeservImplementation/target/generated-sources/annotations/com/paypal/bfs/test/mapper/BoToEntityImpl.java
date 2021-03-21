package com.paypal.bfs.test.mapper;

import com.paypal.bfs.test.employeeserv.api.com.paypal.bfs.test.model.Employee;
import com.paypal.bfs.test.model.bo.EmployeeBo;
import com.paypal.bfs.test.model.entities.EmployeeEntity;
import com.paypal.bfs.test.model.entities.EmployeeEntity.Address;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-22T00:25:22+0530",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 15.0.2 (N/A)"
)
public class BoToEntityImpl implements BoToEntity {

    @Override
    public EmployeeEntity boToEntity(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setId( employee.getId() );
        employeeEntity.setFirstName( employee.getFirstName() );
        employeeEntity.setLastName( employee.getLastName() );
        employeeEntity.setDateOfBirth( employee.getDateOfBirth() );
        employeeEntity.setAddress( addressToAddress( employee.getAddress() ) );

        return employeeEntity;
    }

    @Override
    public Employee entityToBo(EmployeeEntity employeeEntity) {
        if ( employeeEntity == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId( employeeEntity.getId() );
        employee.setFirstName( employeeEntity.getFirstName() );
        employee.setLastName( employeeEntity.getLastName() );
        employee.setDateOfBirth( employeeEntity.getDateOfBirth() );
        employee.setAddress( addressToAddress1( employeeEntity.getAddress() ) );

        return employee;
    }

    @Override
    public EmployeeBo dtoToBo(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeBo employeeBo = new EmployeeBo();

        employeeBo.setId( employee.getId() );
        employeeBo.setFirstName( employee.getFirstName() );
        employeeBo.setLastName( employee.getLastName() );
        employeeBo.setDateOfBirth( employee.getDateOfBirth() );
        employeeBo.setAddress( addressToAddress2( employee.getAddress() ) );

        return employeeBo;
    }

    protected Address addressToAddress(com.paypal.bfs.test.employeeserv.api.com.paypal.bfs.test.model.Address address) {
        if ( address == null ) {
            return null;
        }

        Address address1 = new Address();

        address1.setLine1( address.getLine1() );
        address1.setLine2( address.getLine2() );
        address1.setState( address.getState() );
        address1.setCity( address.getCity() );
        address1.setCountry( address.getCountry() );
        address1.setZipCode( address.getZipCode() );

        return address1;
    }

    protected com.paypal.bfs.test.employeeserv.api.com.paypal.bfs.test.model.Address addressToAddress1(Address address) {
        if ( address == null ) {
            return null;
        }

        com.paypal.bfs.test.employeeserv.api.com.paypal.bfs.test.model.Address address1 = new com.paypal.bfs.test.employeeserv.api.com.paypal.bfs.test.model.Address();

        address1.setLine1( address.getLine1() );
        address1.setLine2( address.getLine2() );
        address1.setState( address.getState() );
        address1.setCity( address.getCity() );
        address1.setCountry( address.getCountry() );
        address1.setZipCode( address.getZipCode() );

        return address1;
    }

    protected com.paypal.bfs.test.model.EmployeeInfo.Address addressToAddress2(com.paypal.bfs.test.employeeserv.api.com.paypal.bfs.test.model.Address address) {
        if ( address == null ) {
            return null;
        }

        com.paypal.bfs.test.model.EmployeeInfo.Address address1 = new com.paypal.bfs.test.model.EmployeeInfo.Address();

        address1.setLine1( address.getLine1() );
        address1.setLine2( address.getLine2() );
        address1.setState( address.getState() );
        address1.setCity( address.getCity() );
        address1.setCountry( address.getCountry() );
        address1.setZipCode( address.getZipCode() );

        return address1;
    }
}
