package com.javastudio.service;

import com.javastudio.api.LoanService;
import com.javastudio.dto.Loan;
import com.javastudio.mapper.LoanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Loan> findAll(Optional<Long> employeeId) {
        if (employeeId.isEmpty())
            return Collections.emptyList();

        String query = "select lt.Title, lp.LoanAmount, lp.Remainder, li.Amount, lp.EmployeeRef, li.PaymentYearMonth from HCM3.LoanPayment lp join HCM3.LoanInstalment li on li.LoanPaymentRef = lp.LoanPaymentID join HCM3.LoanType lt on lt.LoanTypeID = lp.LoanTypeRef where lp.EmployeeRef = ?";
        return jdbcTemplate.query(query, new Object[]{employeeId.get()}, new LoanMapper());
    }
}
