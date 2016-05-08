package org.akhila.cloudservices.rest.services;

import net.sf.json.JSONArray;
import org.akhila.cloudservices.rest.DataBaseConnectionProvider;
import org.akhila.cloudservices.rest.model.Payment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentServiceImpl implements PaymentService{
    private final DataBaseConnectionProvider db;

    public PaymentServiceImpl(DataBaseConnectionProvider db) {
        this.db = db;
    }

    @Override
    public Payment getPaymentBycustomerNumber(int customerNumber) throws SQLException {
        ResultSet resultSet = db.select("Select * from payments where customerNumber="+customerNumber+";");
        Payment payment = new Payment();
        if(resultSet.next()){
            payment.setCustomerNumber(resultSet.getInt(1));
            payment.setCheckNumber(resultSet.getString(2));
            payment.setPaymentDate(resultSet.getDate(3));
            payment.setAmount(resultSet.getDouble(4));
        }
        return payment;
    }

    @Override
    public JSONArray getAllPayments() throws SQLException {
        ResultSet resultSet = db.select("Select * from payments");
        JSONArray array = new JSONArray();
        while (resultSet.next()) {
            Payment payment = new Payment();
            payment.setCustomerNumber(resultSet.getInt(1));
            payment.setCheckNumber(resultSet.getString(2));
            payment.setPaymentDate(resultSet.getDate(3));
            payment.setAmount(resultSet.getDouble(4));
            array.add(payment);
        }
        return array;
    }
}
