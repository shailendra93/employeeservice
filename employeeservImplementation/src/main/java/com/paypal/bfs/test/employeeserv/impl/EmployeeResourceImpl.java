package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.com.paypal.bfs.test.model.Employee;
import com.paypal.bfs.test.enums.ErrorCode;
import com.paypal.bfs.test.enums.ResponseStatus;
import com.paypal.bfs.test.exceptions.ApplicationException;
import com.paypal.bfs.test.exceptions.BadRequestException;
import com.paypal.bfs.test.exceptions.RecordNotFoundException;
import com.paypal.bfs.test.mapper.BoToEntity;
import com.paypal.bfs.test.model.entities.EmployeeEntity;
import com.paypal.bfs.test.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import com.paypal.bfs.test.model.bo.CreateEmployeeResponseBo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;


/**
 * Implementation class for employee resource.
 */
@RestController
@Slf4j
public class EmployeeResourceImpl implements EmployeeResource {

    @Autowired
    private EmployeeRepository employeerepository;


    @Override
    public ResponseEntity<Employee> employeeGetById(final String id) {

        Integer empId = validateEmployeeId(id);
        Employee employee = null;
        try {
             employee = BoToEntity.INSTANCE.entityToBo(employeerepository.findById(empId).get());
            log.info("Employee information from db:{}", employee);
        }catch (Exception ex){
            log.error("there is some issue while  fetching records:{}", ex.getMessage());
        }

        if(ObjectUtils.isEmpty(employee)){
            throw new RecordNotFoundException(ErrorCode.RECORD_NOT_FOUND.getMessage());
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CreateEmployeeResponseBo> createEmployee(final Employee employee) {

        //validate request
        validateCreateEmployeeRequest(employee);

        //save employee in db
        EmployeeEntity entity = null;
        try {
            entity = employeerepository.save(BoToEntity.INSTANCE.boToEntity(employee));
            log.info("employee information after saving in db:{}", entity);
        } catch (Exception ex) {
            log.error("there is some issue while saving records in db:{}", ex.getMessage());
            throw new ApplicationException(ErrorCode.INTERNAL_SERVER_ERROR.getMessage());
        }
        CreateEmployeeResponseBo employeeResponse = CreateEmployeeResponseBo.builder()
                .code(HttpStatus.CREATED.value())
                .employeeId(String.valueOf(entity.getId()))
                .status(ResponseStatus.SUCCESS.name())
                .message("employee data saved successfully!!")
                .build();

        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
    }

    protected void validateCreateEmployeeRequest(final Employee employee){

        if(ObjectUtils.isEmpty(employee)){
            throw new BadRequestException("request body is empty!!");
        }
        if(StringUtils.isEmpty(employee.getFirstName())){
            throw new BadRequestException("first name is mandatory!!");
        }
        if(StringUtils.isEmpty(employee.getLastName())){
            throw new BadRequestException("last name is mandatory!!");
        }
        if(StringUtils.isEmpty(employee.getDateOfBirth())){
            throw new BadRequestException("date of birth is mandatory!!");
        }

        validateDob(employee.getDateOfBirth());

        if(ObjectUtils.isEmpty(employee.getAddress())){
            throw new BadRequestException("address field can't be null!!");
        }
        if(StringUtils.isEmpty(employee.getAddress().getLine1())){
            throw new BadRequestException("line 1 of address is mandatory!!");
        }
        if(StringUtils.isEmpty(employee.getAddress().getCity())){
            throw new BadRequestException("city  is mandatory!!");
        }
        if(StringUtils.isEmpty(employee.getAddress().getState())){
            throw new BadRequestException("state  is mandatory!!");
        }
        if(StringUtils.isEmpty(employee.getAddress().getCountry())){
            throw new BadRequestException("country  is mandatory!!");
        }
        if(StringUtils.isEmpty(employee.getAddress().getZipCode())){
            throw new BadRequestException("zipcode  is mandatory!!");
        }
       validateZipCode(employee.getAddress().getZipCode());

    }

    protected Integer validateEmployeeId(final String id){
        if(StringUtils.isEmpty(id)){
            throw new BadRequestException("id is mandatory");
        }
        Integer empId;
        try {
            empId= Integer.parseInt(id);
        }catch (NumberFormatException ex){
            log.error("id should be numeric:{}", ex.getMessage());
            throw new IllegalArgumentException("invalid employee Id");
        }
        return empId;
    }

    protected void validateDob(final String dateStr){

        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            log.error("invalid dob format!!");
            throw new BadRequestException("invalid dob format!!");
        }
    }

    protected void validateZipCode(final String zipCode){

        String regex = "^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$";
        Pattern pattern = Pattern.compile(regex);
        if(!pattern.matcher(zipCode).matches()){
            throw new BadRequestException("invalid zip code");
        }
    }
}
