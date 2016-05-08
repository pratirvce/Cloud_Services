package org.akhila.cloudservices.rest.services;

import net.sf.json.JSONArray;
import org.akhila.cloudservices.rest.model.Order;

import java.sql.SQLException;

public interface OrderService {
    public Order getOrderByOrderNumber(int orderNumber) throws SQLException;
    public JSONArray getAllOrders() throws SQLException;
}
