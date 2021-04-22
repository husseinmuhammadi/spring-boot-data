package com.javastudio.api;

import com.javastudio.dto.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findByCode(String code);

    Employee findById(Long id);
}
