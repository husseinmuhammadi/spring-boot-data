package com.javastudio.service;

import com.javastudio.api.EmployeeService;
import com.javastudio.dto.Employee;
import com.javastudio.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query("select EmployeeID, Code, Status, * from HCM3.Employee", new EmployeeMapper());
    }
}
