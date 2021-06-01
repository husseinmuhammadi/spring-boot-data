package com.javastudio.mapper;

import com.javastudio.dto.Loan;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoanMapper implements RowMapper<Loan> {
    @Override
    public Loan mapRow(ResultSet resultSet, int i) throws SQLException {
        Loan loan = new Loan();
        loan.setTitle(resultSet.getString("Title"));
        loan.setPrincipal(resultSet.getLong("LoanAmount"));
        loan.setOutstanding(resultSet.getLong("Remainder"));
        loan.setInstallment(resultSet.getLong("Amount"));
        loan.setPaymentYearMonth(resultSet.getString("PaymentYearMonth"));
        loan.setEmployeeId(resultSet.getLong("EmployeeRef"));
        return loan;
    }
}
