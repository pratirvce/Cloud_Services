package org.akhila.cloudservices.rest.services;

import net.sf.json.JSONArray;
import org.akhila.cloudservices.rest.model.OrderDetails;

import java.sql.SQLException;

public interface OrderDetailsService {
    public OrderDetails getOrderDetailsByOrderNumberAndProductCode(int orderNumber, String productCode) throws SQLException;
    public JSONArray getAllOrderDetails() throws SQLException;
}
