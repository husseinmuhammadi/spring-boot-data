package com.javastudio.mapper;

import com.javastudio.dto.Attendance;
import com.javastudio.dto.Loan;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AttendanceMapper implements RowMapper<Attendance> {
    @Override
    public Attendance mapRow(ResultSet resultSet, int i) throws SQLException {
        Attendance attendance = new Attendance();
        attendance.setAttendanceFactorID(resultSet.getLong("AttendanceFactorID"));
        attendance.setTitle(resultSet.getString("Title"));
        attendance.setValue(resultSet.getLong("Value"));
        attendance.setEmployeeId(resultSet.getLong("EmployeeRef"));
        attendance.setIssueYearMonth(resultSet.getString("IssueYearMonth"));
        return attendance;
    }
}
