package com.javastudio.service;

import com.javastudio.api.AttendanceService;
import com.javastudio.api.LoanService;
import com.javastudio.dto.Attendance;
import com.javastudio.dto.Loan;
import com.javastudio.mapper.AttendanceMapper;
import com.javastudio.mapper.LoanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Attendance> findAll(Optional<Long> employeeId, Optional<String> issueYearMonth) {
        if (employeeId.isEmpty() || issueYearMonth.isEmpty())
            return Collections.emptyList();

        String query =
                "select af.AttendanceFactorID, af.Title, acmi.Value, ac.EmployeeRef, ac.IssueYearMonth from HCM3.AttendanceCalcMonthlyItem acmi " +
                        "  join HCM3.AttendanceCalc ac " +
                        "    on ac.AttendanceCalcID = acmi.AttendanceCalcRef " +
                        "  join HCM3.AttendanceFactor af " +
                        "    on af.AttendanceFactorID = acmi.AttendanceFactorRef " +
                        "where ac.IssueYearMonth = ? " +
                        "  and ac.EmployeeRef = ?";
        return jdbcTemplate.query(query, new Object[]{
                issueYearMonth.get(), employeeId.get()
        }, new AttendanceMapper());
    }
}
