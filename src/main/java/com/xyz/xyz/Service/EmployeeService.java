package com.xyz.xyz.Service;

import com.xyz.xyz.entity.Employee;
import com.xyz.xyz.exception.ResourceNotFound;
import com.xyz.xyz.payload.EmployeeDto;
import com.xyz.xyz.repository.EmployeeRepository;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class EmployeeService {
   @Autowired
    private EmployeeRepository employeeRepository;
   @Autowired
   private ModelMapper modelMapper;
    public EmployeeDto addEmployee(EmployeeDto dto) {
        Employee employee = mapToEntity(dto);// Converts DTO to Entity
        Employee emp = employeeRepository.save(employee); // Saves entity to DB
        EmployeeDto employeeDto = mapToDto(emp);
        employeeDto.setDate(new Date());
        return employeeDto; // Return DTO
    }


    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public EmployeeDto updateEmployee(Long id, EmployeeDto dto) {
   Employee employee= mapToEntity(dto);
   employee.setId(id);
       Employee updateEmployee= employeeRepository.save(employee);
       EmployeeDto employeeDto=mapToDto(updateEmployee);
       return employeeDto;
    }

    public List<EmployeeDto> getEmployee() {
        List<Employee>employees=employeeRepository.findAll();
        List<EmployeeDto> dto=employees.stream().map(e->mapToDto(e)).collect(Collectors.toList());
        return dto;
    }
    Employee mapToEntity(EmployeeDto dto){
       Employee emp= modelMapper.map(dto,Employee.class);
//        Employee emp = new Employee();
//        emp.setId(dto.getId());
//        emp.setName(dto.getName());
//        emp.setEmail(dto.getEmail());
//        emp.setMobile(dto.getMobile());
        return emp;

    }
    EmployeeDto mapToDto(Employee employee) {
       EmployeeDto dto= modelMapper.map(employee,EmployeeDto.class);
//        EmployeeDto dto = new EmployeeDto();
//       dto.setId(employee.getId());
//        dto.setName(employee.getName());
//        dto.setEmail(employee.getEmail());
//        dto.setMobile(employee.getMobile());
        return dto;

    }

    public EmployeeDto getAllEmp(Long id) {
      Employee employee= employeeRepository.findById(id).orElseThrow(
              ()->new ResourceNotFound("Resource Not Found"+id));


      EmployeeDto dto= mapToDto(employee);
      return dto;

    }
}


