package com.acme.dao;

import com.acme.domain.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {

    List<Employee> getAllUsers() throws SQLException;
}
