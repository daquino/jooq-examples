package com.example.jooq.util;


import org.apache.tomcat.jdbc.pool.DataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    public static DataSource createDataSource() {
        DataSource ds = new DataSource();
        ds.setUsername("daquino");
        ds.setPassword("");
        ds.setUrl("jdbc:postgresql://localhost/sample");
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setDefaultAutoCommit(true);
        ds.setMinIdle(1);
        ds.setMaxIdle(5);
        ds.setMaxActive(5);
        ds.setInitialSize(2);
        ds.setMaxWait(5000);
        ds.setValidationQuery("select 2 from dual");
        ds.setTestWhileIdle(true);
        ds.setTimeBetweenEvictionRunsMillis(600000);
        return ds;
    }

    public static Connection createConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/sample", "daquino", "");
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
