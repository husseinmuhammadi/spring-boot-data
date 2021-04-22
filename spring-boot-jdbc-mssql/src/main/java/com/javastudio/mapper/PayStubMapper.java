package com.javastudio.mapper;

import com.javastudio.dto.PayStub;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PayStubMapper implements RowMapper<PayStub> {
    @Override
    public PayStub mapRow(ResultSet resultSet, int i) throws SQLException {
        PayStub payStub = new PayStub();
        payStub.setId(resultSet.getLong("PayCalcID"));
        payStub.setIssueYearMonth(resultSet.getString("IssueYearMonth"));
        payStub.setEmployeeId(resultSet.getLong("EmployeeRef"));
        return payStub;
    }
}
