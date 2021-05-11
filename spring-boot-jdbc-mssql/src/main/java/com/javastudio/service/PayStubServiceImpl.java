package com.javastudio.service;

import com.javastudio.api.PayStubService;
import com.javastudio.dto.PayStub;
import com.javastudio.mapper.PayStubMapper;
import com.javastudio.mapper.PayStubYearsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PayStubServiceImpl implements PayStubService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<PayStub> findAll(Optional<Long> employeeId) {
        if (employeeId.isEmpty())
            return Collections.emptyList();

        String query = "select PayCalcID, IssueYearMonth, EmployeeRef from HCM3.PayCalc where EmployeeRef = ? order by IssueYearMonth desc";
        return jdbcTemplate.query(query, new Object[]{employeeId.get()}, new PayStubMapper());
    }

    @Override
    public List<String> findIssueYears(Optional<Long> employeeId) {
        if (employeeId.isEmpty())
            return Collections.emptyList();

        String query = "select distinct (pc.IssueYearMonth/100) IssueYear from HCM3.PayCalc pc and IssueYearMonth >= 140000 where pc.EmployeeRef = ? order by (pc.IssueYearMonth/100);";
        return jdbcTemplate.query(query, new Object[]{employeeId.get()}, new PayStubYearsMapper());
    }

    @Override
    public PayStub findById(Long id) {
        return jdbcTemplate.queryForObject("select PayCalcID, IssueYearMonth, EmployeeRef from HCM3.PayCalc where PayCalcID = ?", new Object[]{id}, new PayStubMapper());
    }
}
