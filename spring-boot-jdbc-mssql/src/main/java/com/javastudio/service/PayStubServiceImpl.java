package com.javastudio.service;

import com.javastudio.api.PayStubService;
import com.javastudio.dto.Employee;
import com.javastudio.dto.PayStub;
import com.javastudio.mapper.EmployeeMapper;
import com.javastudio.mapper.PayStubMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PayStubServiceImpl implements PayStubService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<PayStub> findAll(@RequestParam("employeeId") Optional<Long> employeeId) {
        if (employeeId.isEmpty())
            return Collections.emptyList();

        String query = "select PayCalcID, IssueYearMonth, EmployeeRef from HCM3.PayCalc where EmployeeRef = ? order by pc.IssueYearMonth desc";
        return jdbcTemplate.query(query, new Object[]{employeeId.get()}, new PayStubMapper());
    }

    @Override
    public Employee findById(Long id) {
        return jdbcTemplate.queryForObject("select PayCalcID, IssueYearMonth, EmployeeRef from HCM3.PayCalc where PayCalcID = ?", new Object[]{id}, new EmployeeMapper());
    }
}
