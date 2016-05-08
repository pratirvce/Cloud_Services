package org.akhila.cloudservices.rest.services;

import net.sf.json.JSONArray;

import java.sql.SQLException;

import org.akhila.cloudservices.rest.model.Payment;

public interface PaymentService {
    public Payment getPaymentBycustomerNumber(int customerNumber) throws SQLException;
    public JSONArray getAllPayments() throws SQLException;
}
