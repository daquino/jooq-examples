package com.example.jooq.test;

import com.example.jooq.LoggingListener;
import com.example.jooq.util.Util;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultConnectionProvider;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.junit.Test;

import java.sql.Connection;

import static com.example.jooq.model.tables.Movie.MOVIE;

public class DSLTest {

    @Test
    public void testCreatingDslContext() throws Exception {
        Connection connection = Util.createConnection();
        DataSource dataSource = Util.createDataSource();


        DSLContext dslFromConnection = DSL.using(connection);
        DSLContext dslFromDataSource = DSL.using(dataSource, SQLDialect.POSTGRES);
        DSLContext dslFromConnectionProvider = DSL.using(new DefaultConnectionProvider(connection),
                SQLDialect.POSTGRES);
        DSLContext dslFromConfiguration = DSL.using(new DefaultConfiguration()
                        .set(connection)
                        .set(new DefaultExecuteListenerProvider(new LoggingListener()))
        );

        dslFromConfiguration.selectFrom(MOVIE).fetch();
    }
}
