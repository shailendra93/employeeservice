package com.paypal.bfs.test.mapper;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.paypal.bfs.test.employeeserv.api.com.paypal.bfs.test.model.Employee;
import com.paypal.bfs.test.model.bo.EmployeeBo;
import com.paypal.bfs.test.model.entities.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BoToEntity {

    BoToEntity INSTANCE = Mappers.getMapper(BoToEntity.class);

    ObjectMapper objectMapper = new ObjectMapper();

    EmployeeEntity boToEntity(final Employee employee);

    Employee entityToBo(final EmployeeEntity employeeEntity);

    EmployeeBo dtoToBo(final Employee employee);


}
