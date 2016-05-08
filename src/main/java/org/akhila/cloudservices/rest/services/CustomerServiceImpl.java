package org.akhila.cloudservices.rest.services;

import net.sf.json.JSONArray;
import org.akhila.cloudservices.rest.DataBaseConnectionProvider;
import org.akhila.cloudservices.rest.model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerServiceImpl implements CustomerService{
    private final DataBaseConnectionProvider db;

    public CustomerServiceImpl(DataBaseConnectionProvider db) {
        this.db = db;
    }

    @Override
    public Customer getCustomerByCustomerNumber(int customerNumber) throws SQLException {
        ResultSet resultSet = db.select("Select * from customers where customerNumber="+customerNumber+";");
        Customer customer = new Customer();
        if(resultSet.next()){
            customer.setCustomerNumber(resultSet.getInt(1));
            customer.setCustomerName(resultSet.getString(2));
            customer.setContactLastName(resultSet.getString(3));
            customer.setContactFirstName(resultSet.getString(4));
            customer.setPhone(resultSet.getString(5));
            customer.setAddressLine1(resultSet.getString(6));
            customer.setAddressLine2(resultSet.getString(7));
            customer.setCity(resultSet.getString(8));
            customer.setState(resultSet.getString(9));
            customer.setPostalCode(resultSet.getString(10));
            customer.setCountry(resultSet.getString(11));
            customer.setSalesRepEmployeeNumber(resultSet.getInt(12));
            customer.setCreditLimit(resultSet.getDouble(13));
        }
        return customer;
    }

    @Override
    public JSONArray getAllCustomers() throws SQLException {
        ResultSet resultSet = db.select("Select * from customers");
        JSONArray array = new JSONArray();
        while (resultSet.next()) {
            Customer customer = new Customer();
            customer.setCustomerNumber(resultSet.getInt(1));
            customer.setCustomerName(resultSet.getString(2));
            customer.setContactLastName(resultSet.getString(3));
            customer.setContactFirstName(resultSet.getString(4));
            customer.setPhone(resultSet.getString(5));
            customer.setAddressLine1(resultSet.getString(6));
            customer.setAddressLine2(resultSet.getString(7));
            customer.setCity(resultSet.getString(8));
            customer.setState(resultSet.getString(9));
            customer.setPostalCode(resultSet.getString(10));
            customer.setCountry(resultSet.getString(11));
            customer.setSalesRepEmployeeNumber(resultSet.getInt(12));
            customer.setCreditLimit(resultSet.getDouble(13));
            array.add(customer);
        }
        return array;
    }
}
