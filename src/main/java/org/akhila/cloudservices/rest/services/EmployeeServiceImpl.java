package org.akhila.cloudservices.rest.services;

import net.sf.json.JSONArray;
import org.akhila.cloudservices.rest.DataBaseConnectionProvider;
import org.akhila.cloudservices.rest.model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeServiceImpl implements EmployeeService {
    private final DataBaseConnectionProvider db;

    public EmployeeServiceImpl(DataBaseConnectionProvider db) {
        this.db = db;
    }

    @Override
    public Employee getEmployeeByEmployeeNumber(int employeeNumber)throws SQLException {
        ResultSet resultSet = db.select("Select * from employees where employeeNumber="+employeeNumber+";");
        Employee employee = new Employee();
        if(resultSet.next()){
            employee.setEmployeeNumber(resultSet.getInt(1));
            employee.setLastName(resultSet.getString(2));
            employee.setFirstName(resultSet.getString(3));
            employee.setExtension(resultSet.getString(4));
            employee.setEmail(resultSet.getString(5));
            employee.setOfficeCode(resultSet.getString(6));
            employee.setReportsTo(resultSet.getInt(7));
            employee.setJobTitle(resultSet.getString(8));
        }
        return employee;
    }

    @Override
    public JSONArray getAllEmployees() throws SQLException {
        ResultSet resultSet = db.select("Select * from employees");
        JSONArray array = new JSONArray();
        while (resultSet.next()) {
            Employee employee = new Employee();
            employee.setEmployeeNumber(resultSet.getInt(1));
            employee.setLastName(resultSet.getString(2));
            employee.setFirstName(resultSet.getString(3));
            employee.setExtension(resultSet.getString(4));
            employee.setEmail(resultSet.getString(5));
            employee.setOfficeCode(resultSet.getString(6));
            employee.setReportsTo(resultSet.getInt(7));
            employee.setJobTitle(resultSet.getString(8));
            array.add(employee);
        }
        return array;
    }
}
