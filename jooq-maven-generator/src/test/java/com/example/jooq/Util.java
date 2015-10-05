package com.example.jooq;


import org.apache.tomcat.jdbc.pool.DataSource;

public class Util {

    public static DataSource createDataSource() {
        DataSource ds = new DataSource();
        ds.setUsername("daquino");
        ds.setPassword("");
        ds.setUrl("jdbc:postgresql://localhost/sample");
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setDefaultAutoCommit(true);
        ds.setMaxActive(5);
        ds.setInitialSize(2);
        ds.setMaxWait(5000);
        ds.setValidationQuery("select 2 from dual");
        ds.setTestWhileIdle(true);
        ds.setTimeBetweenEvictionRunsMillis(600000);
        return ds;
    }
}
