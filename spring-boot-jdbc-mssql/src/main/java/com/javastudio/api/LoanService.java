package com.javastudio.api;

import com.javastudio.dto.Loan;

import java.util.List;
import java.util.Optional;

public interface LoanService {
    List<Loan> findAll(Optional<Long> employeeId);
}
