package com.javastudio.mapper;

import com.javastudio.dto.Employee;
import com.javastudio.dto.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee=new Employee();
        employee.setId(resultSet.getLong("EmployeeID"));
        employee.setCode(resultSet.getString("Code"));
        employee.setStatus(resultSet.getLong("Status"));
        return employee;
    }
}
