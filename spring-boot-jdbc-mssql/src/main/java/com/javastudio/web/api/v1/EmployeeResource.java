package com.javastudio.web.api.v1;

import com.javastudio.api.EmployeeService;
import com.javastudio.api.PayStubService;
import com.javastudio.dto.Employee;
import com.javastudio.dto.PayStub;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeResource {

    private final Logger logger;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PayStubService payStubService;

    public EmployeeResource(Logger logger) {
        this.logger = logger;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> findAll(@RequestParam("code") Optional<String> code) {
        logger.info("code: {}", code);
        List<Employee> employees;
        if (code.isPresent())
            employees = employeeService.findByCode(code.get());
        else
            employees = employeeService.findAll();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @GetMapping("/{id}/paystubs")
    public ResponseEntity<List<PayStub>> findAllPayStubs(@PathVariable("id") Long id) {
        return ResponseEntity.ok(payStubService.findAll(Optional.of(id)));
    }
}
