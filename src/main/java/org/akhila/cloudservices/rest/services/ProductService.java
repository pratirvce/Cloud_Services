package org.akhila.cloudservices.rest.services;

import net.sf.json.JSONArray;

import java.sql.SQLException;

import org.akhila.cloudservices.rest.model.Product;

public interface ProductService {
    public Product getProductByProductCode(int productCode)  throws SQLException;
    public JSONArray getAllProducts()  throws SQLException;
}
