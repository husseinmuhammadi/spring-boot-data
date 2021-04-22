package com.javastudio.api;

import com.javastudio.dto.Employee;
import com.javastudio.dto.PayStub;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface PayStubService {
    List<PayStub> findAll(@RequestParam("employeeId") Optional<Long> employeeId);

    Employee findById(Long id);
}
