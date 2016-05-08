package org.akhila.cloudservices.rest.services;

import net.sf.json.JSONArray;
import org.akhila.cloudservices.rest.DataBaseConnectionProvider;
import org.akhila.cloudservices.rest.model.Office;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OfficeServiceImpl implements OfficeService{
    private final DataBaseConnectionProvider db;

    public OfficeServiceImpl(DataBaseConnectionProvider db) {
        this.db = db;
    }

    @Override
    public Office getOfficeByOfficeCode(String officeCode) throws SQLException {
        ResultSet resultSet = db.select("Select * from offices where officeCode='"+officeCode+"';");
        Office office = new Office();
        if(resultSet.next()){
            office.setOfficeCode(resultSet.getString(1));
            office.setCity(resultSet.getString(2));
            office.setPhone(resultSet.getString(3));
            office.setAddressLine1(resultSet.getString(4));
            office.setAddressLine2(resultSet.getString(5));
            office.setCity(resultSet.getString(6));
            office.setCountry(resultSet.getString(7));
            office.setPostalCode(resultSet.getString(8));
            office.setTerritory(resultSet.getString(9));
        }
        return office;
    }

    @Override
    public JSONArray getAllOffices() throws SQLException {
        ResultSet resultSet = db.select("Select * from offices");
        JSONArray array = new JSONArray();
        while (resultSet.next()) {
            Office office = new Office();
            office.setOfficeCode(resultSet.getString(1));
            office.setCity(resultSet.getString(2));
            office.setPhone(resultSet.getString(3));
            office.setAddressLine1(resultSet.getString(4));
            office.setAddressLine2(resultSet.getString(5));
            office.setCity(resultSet.getString(6));
            office.setCountry(resultSet.getString(7));
            office.setPostalCode(resultSet.getString(8));
            office.setTerritory(resultSet.getString(9));
            array.add(office);
        }
        return array;

    }
//
//    public static void main(String args[]) throws Exception {
//        new OfficeServiceImpl(DataBaseConnectionProvider.getDatabaseProvider()).getOfficeByOfficeCode("1");
//    }
}
