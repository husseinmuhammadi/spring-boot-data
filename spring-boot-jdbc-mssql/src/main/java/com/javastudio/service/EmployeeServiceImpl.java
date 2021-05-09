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
        return jdbcTemplate.query("select top 200 e.EmployeeID, e.Code, e.Status, p.FirstName, p.LastName from HCM3.Employee e join GNR3.Party p on e.PartyRef = p.PartyID", new EmployeeMapper());
    }

    @Override
    public List<Employee> findByCode(String code) {
        return jdbcTemplate.query("select e.EmployeeID, e.Code, e.Status, p.FirstName, p.LastName from HCM3.Employee e join GNR3.Party p on e.PartyRef = p.PartyID where e.Code = ?", new Object[]{code}, new EmployeeMapper());
    }

    @Override
    public Employee findById(Long id) {
        return jdbcTemplate.queryForObject("select EmployeeID, Code, Status, * from HCM3.Employee where EmployeeID = ?", new Object[]{id}, new EmployeeMapper());
    }




}
