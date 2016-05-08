package org.akhila.cloudservices.rest.services;

import net.sf.json.JSONArray;
import org.akhila.cloudservices.rest.DataBaseConnectionProvider;
import org.akhila.cloudservices.rest.model.Order;

import java.sql.ResultSet;
import java.sql.SQLException;


public class OrderServiceImpl implements OrderService {
    private final DataBaseConnectionProvider db;

    public OrderServiceImpl(DataBaseConnectionProvider db){
        this.db =db;
    }
    @Override
    public Order getOrderByOrderNumber(int orderNumber) throws SQLException {
        ResultSet resultSet = db.select("select * from orders where orderNumber ="+orderNumber+";");
        Order order = new Order();
        if(resultSet.next()){
            order.setOrderNumber(resultSet.getInt(1));
            order.setOrderDate(resultSet.getDate(2));
            order.setRequiredDate(resultSet.getDate(3));
            order.setShippedDate(resultSet.getDate(4));
            order.setStatus(resultSet.getString(5));
            order.setComments(resultSet.getString(6));
            order.setCustomerNumber(resultSet.getInt(7));
        }
        return order;
    }

    @Override
    public JSONArray getAllOrders() throws SQLException {
        ResultSet resultSet = db.select("Select * from orders");
        JSONArray array = new JSONArray();
        while(resultSet.next()){
            Order order = new Order();
            order.setOrderNumber(resultSet.getInt(1));
            order.setOrderDate(resultSet.getDate(2));
            order.setRequiredDate(resultSet.getDate(3));
            order.setShippedDate(resultSet.getDate(4));
            order.setStatus(resultSet.getString(5));
            order.setComments(resultSet.getString(6));
            order.setCustomerNumber(resultSet.getInt(7));
            array.add(order);
        }
        return array;
    }
}
