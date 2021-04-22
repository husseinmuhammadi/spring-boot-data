package com.javastudio.web.api.v1;

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
@RequestMapping("/api/v1/paystubs")
public class PayStubResource {

    private final Logger logger;

    @Autowired
    private PayStubService payStubService;

    public PayStubResource(Logger logger) {
        this.logger = logger;
    }

    @GetMapping
    public ResponseEntity<List<PayStub>> findAll(@RequestParam("employeeId") Optional<Long> employeeId) {
        return ResponseEntity.ok(payStubService.findAll(employeeId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(payStubService.findById(id));
    }
}
