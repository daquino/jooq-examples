package com.example.jooq.test;

import com.example.jooq.util.Util;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.Result;
import org.jooq.impl.DSL;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.example.jooq.model.tables.Actor.ACTOR;

public class JdbcVersusJooqTest {

    @Test
    public void testExceptionHandling() throws Exception {

        try (Connection connection = Util.createConnection()) {

            try (PreparedStatement statement =
                         connection.prepareStatement("select last_name from actor")) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1));
                }
            }
        }


        try (Connection connection = Util.createConnection()) {
            for (Record record : DSL.using(connection)
                    .select(ACTOR.LAST_NAME)
                    .from(ACTOR)
                    .fetch()) {
                System.out.println(record.getValue(ACTOR.LAST_NAME));
            }
        }

    }
}
