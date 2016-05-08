package org.akhila.cloudservices.rest.services;

import net.sf.json.JSONArray;
import org.akhila.cloudservices.rest.DataBaseConnectionProvider;
import org.akhila.cloudservices.rest.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductServiceImpl implements ProductService {
    private final DataBaseConnectionProvider db;

    public ProductServiceImpl(DataBaseConnectionProvider db) {
        this.db = db;
    }

    @Override
    public Product getProductByProductCode(int productCode)throws SQLException {
        ResultSet resultSet = db.select("Select * from products where productCode="+productCode+";");
        Product product = new Product();
        if(resultSet.next()){
            product.setProductCode(resultSet.getString(1));
            product.setProductName(resultSet.getString(2));
            product.setProductLine(resultSet.getString(3));
            product.setProductScale(resultSet.getString(4));
            product.setProductVendor(resultSet.getString(5));
            product.setProductDescription(resultSet.getString(6));
            product.setQuantityInStock(resultSet.getInt(7));
            product.setBuyprice(resultSet.getDouble(8));
			product.setMsrp(resultSet.getDouble(9));
        }
        return product;
    }

    @Override
    public JSONArray getAllProducts() throws SQLException {
        ResultSet resultSet = db.select("Select * from products");
        JSONArray array = new JSONArray();
        while (resultSet.next()) {
            Product product = new Product();
            product.setProductCode(resultSet.getString(1));
            product.setProductName(resultSet.getString(2));
            product.setProductLine(resultSet.getString(3));
            product.setProductScale(resultSet.getString(4));
            product.setProductVendor(resultSet.getString(5));
            product.setProductDescription(resultSet.getString(6));
            product.setQuantityInStock(resultSet.getInt(7));
            product.setBuyprice(resultSet.getDouble(8));
			product.setMsrp(resultSet.getDouble(9));
            array.add(product);
        }
        return array;
    }
}
