package org.akhila.cloudservices.rest.services;

import net.sf.json.JSONArray;
import org.akhila.cloudservices.rest.DataBaseConnectionProvider;
import org.akhila.cloudservices.rest.model.OrderDetails;

import java.sql.ResultSet;
import java.sql.SQLException;


public class OrderDetailsServiceImpl implements OrderDetailsService {
    private final DataBaseConnectionProvider db;

    public OrderDetailsServiceImpl(DataBaseConnectionProvider db) {
        this.db = db;
    }

    @Override
    public OrderDetails getOrderDetailsByOrderNumberAndProductCode(int orderNumber, String productCode) throws SQLException {
        ResultSet resultSet = db.select("Select * from orderdetails where orderNumber="+ orderNumber + " and  productCode='"+productCode+"';");
        OrderDetails orderDetails = new OrderDetails();
        if(resultSet.next()){
            orderDetails.setOrderNumber(resultSet.getInt(1));
            orderDetails.setProductCode(resultSet.getString(2));
            orderDetails.setQuantityOrdered(resultSet.getInt(3));
            orderDetails.setPriceEach(resultSet.getDouble(4));
            orderDetails.setOrderLineNumber(resultSet.getInt(5));
        }

        return orderDetails;
    }

    @Override
    public JSONArray getAllOrderDetails() throws SQLException {
        ResultSet resultSet = db.select("Select * from orderdetails");
        JSONArray array = new JSONArray();
        while (resultSet.next()) {
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setOrderNumber(resultSet.getInt(1));
            orderDetails.setProductCode(resultSet.getString(2));
            orderDetails.setQuantityOrdered(resultSet.getInt(3));
            orderDetails.setPriceEach(resultSet.getDouble(4));
            orderDetails.setOrderLineNumber(resultSet.getInt(5));
            array.add(orderDetails);
        }
        return array;

    }

    public static void main(String args[]) throws Exception{
        new OrderDetailsServiceImpl(DataBaseConnectionProvider.getDatabaseProvider()).getOrderDetailsByOrderNumberAndProductCode(10100, "S18_1749");
    }
}
