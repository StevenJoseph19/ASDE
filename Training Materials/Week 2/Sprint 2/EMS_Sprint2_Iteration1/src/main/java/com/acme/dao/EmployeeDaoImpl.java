package com.acme.dao;

import com.acme.connect.ConnectionManager;
import com.acme.domain.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    String SQL_SELECT;

    public List getAllUsers() throws SQLException {
        SQL_SELECT = "Select * from EMPLOYEE";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT);
             ResultSet resultSet = preparedStatement.executeQuery();) {


            List employees = new ArrayList();

            while (resultSet.next()) {
                Employee employee = extractUserFromResultSet(resultSet);
                employees.add(employee);
            }

            return employees;
        }
    }

    public  Employee extractUserFromResultSet(ResultSet resultSet) throws SQLException {


        int id = resultSet.getInt("ID");
        String name = resultSet.getString("NAME");
        long contact = resultSet.getLong("CONTACT");
        String department = resultSet.getString("DEPARTMENT");
        String email = resultSet.getString("EMAIL");
        String address = resultSet.getString("ADDRESS");

        Employee emp = new Employee();
        emp.setEmpID(id);
        emp.setEmpName(name);
        emp.setEmpContact(contact);
        emp.setEmpDepartment(department);
        emp.setEmpEmail(email);
        emp.setEmpAddress(address);

        return emp;
    }
}
