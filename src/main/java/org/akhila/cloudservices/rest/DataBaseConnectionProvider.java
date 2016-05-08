package org.akhila.cloudservices.rest;

import java.sql.*;

public class DataBaseConnectionProvider {
    private static DataBaseConnectionProvider dataBaseConnectionProvider;

    private Connection connection;

    private DataBaseConnectionProvider() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://cloudservice.csa2yphklgn8.us-east-1.rds.amazonaws.com:3306/classicmodels",
                "root", "cloud007");
    }

    public static DataBaseConnectionProvider getDatabaseProvider() throws SQLException, ClassNotFoundException {
        if (dataBaseConnectionProvider == null) {
            dataBaseConnectionProvider = new DataBaseConnectionProvider();
        }
        return dataBaseConnectionProvider;
    }

    public ResultSet select(String query) throws SQLException {
        return connection.createStatement().executeQuery(query);
    }

    public int insertUpdateDelete(String query) throws SQLException {
        return connection.createStatement().executeUpdate(query);
    }

    public static void main(String args[]) throws Exception {
        DataBaseConnectionProvider db = getDatabaseProvider();
        ResultSet rs = db.select("select * from customers");
        System.out.print("");
    }
}
