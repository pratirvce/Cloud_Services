package org.akhila.cloudservices.rest.services;

import net.sf.json.JSONArray;
import org.akhila.cloudservices.rest.model.Customer;

import java.sql.SQLException;

public interface CustomerService {
    public Customer getCustomerByCustomerNumber(int customerNumber) throws SQLException;
    public JSONArray getAllCustomers() throws SQLException;
}
