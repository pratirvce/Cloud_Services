package org.akhila.cloudservices.rest.services;

import net.sf.json.JSONArray;
import org.akhila.cloudservices.rest.model.Office;

import java.sql.SQLException;

public interface OfficeService {
    public Office getOfficeByOfficeCode(String officeCode) throws SQLException;
    public JSONArray getAllOffices() throws SQLException;
}
