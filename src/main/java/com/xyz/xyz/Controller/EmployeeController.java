package com.xyz.xyz.Controller;


import com.xyz.xyz.Service.EmployeeService;
import com.xyz.xyz.entity.Employee;
import com.xyz.xyz.payload.EmployeeDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    private ModelMapper modelMapper;
    @PostMapping("/add") // Use @PostMapping for clarity when adding data
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto dto) {
        System.out.println("vdkjvn");

        EmployeeDto employeeDto = employeeService.addEmployee(dto); // Call service layer
        return new ResponseEntity<>(employeeDto, HttpStatus.CREATED); // Return response
    }

    @DeleteMapping
    public ResponseEntity<String> deleteEmployee(Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("deleted",HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestParam Long id,@RequestBody EmployeeDto dto){
        EmployeeDto updateemp=employeeService.updateEmployee(id,dto);

     return new ResponseEntity<>(updateemp,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
       List<EmployeeDto> empdto= employeeService.getEmployee();
       return new ResponseEntity<>(empdto,HttpStatus.OK);

    }
    @GetMapping("/employeeId/{id}")
    public ResponseEntity<EmployeeDto> getEmployeebyId(@PathVariable long id){
        EmployeeDto dto=employeeService.getAllEmp(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);


    }
}
