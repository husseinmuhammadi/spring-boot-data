package com.javastudio.api;

import com.javastudio.dto.Attendance;
import com.javastudio.dto.Loan;

import java.util.List;
import java.util.Optional;

public interface AttendanceService {
    List<Attendance> findAll(Optional<Long> employeeId,Optional<String> issueYearMonth);
}
