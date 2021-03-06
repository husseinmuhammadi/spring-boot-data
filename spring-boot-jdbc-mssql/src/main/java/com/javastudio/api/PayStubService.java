package com.javastudio.api;

import com.javastudio.dto.Employee;
import com.javastudio.dto.PayStub;

import java.util.List;
import java.util.Optional;

public interface PayStubService {
    List<PayStub> findAll(Optional<Long> employeeId);

    List<String> findIssueYears(Optional<Long> employeeId);

    PayStub findById(Long id);
}
