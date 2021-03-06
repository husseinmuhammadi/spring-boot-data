package com.javastudio.web.api.v1;

import com.javastudio.api.AttendanceService;
import com.javastudio.api.EmployeeService;
import com.javastudio.api.LoanService;
import com.javastudio.api.PayStubService;
import com.javastudio.dto.Attendance;
import com.javastudio.dto.Employee;
import com.javastudio.dto.Loan;
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

    @Autowired
    private LoanService loanService;

    @Autowired
    private AttendanceService attendanceService;

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

    @GetMapping("/{id}/loans")
    public ResponseEntity<List<Loan>> findAllLoans(@PathVariable("id") Long id) {
        return ResponseEntity.ok(loanService.findAll(Optional.of(id)));
    }

    @GetMapping("/{id}/attendance/{year}/{month}")
    public ResponseEntity<List<Attendance>> findAllAttendance(@PathVariable("id") Long id, @PathVariable("year") String year, @PathVariable("month") String month) {
        return ResponseEntity.ok(attendanceService.findAll(Optional.of(id), Optional.of(year + month)));
    }

    @GetMapping("/{id}/paystubs/issue-years")
    public ResponseEntity<List<String>> findAllYearsWithPayStub(@PathVariable("id") Long id) {
        return ResponseEntity.ok(payStubService.findIssueYears(Optional.of(id)));
    }
}
