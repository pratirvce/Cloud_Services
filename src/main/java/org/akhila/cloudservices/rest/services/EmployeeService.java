package org.akhila.cloudservices.rest.services;

import net.sf.json.JSONArray;
import org.akhila.cloudservices.rest.model.Employee;

import java.sql.SQLException;

public interface EmployeeService {
    public Employee getEmployeeByEmployeeNumber(int employeeNumber) throws SQLException;

    public JSONArray getAllEmployees() throws SQLException;
}
