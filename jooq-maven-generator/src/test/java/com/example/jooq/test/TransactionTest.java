package com.example.jooq.test;

import com.example.jooq.model.tables.Movie;
import com.example.jooq.util.Util;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.util.h2.H2DSL;
import org.jooq.util.mysql.MySQLDSL;
import org.jooq.util.postgres.PostgresDSL;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;

import static com.example.jooq.model.tables.Movie.MOVIE;
import static org.jooq.impl.DSL.*;
import static org.jooq.impl.DSL.date;

public class TransactionTest {

    @Test
    public void testTransactions() throws Exception {
        DSLContext dsl = using(Util.createDataSource(), SQLDialect.POSTGRES);

        try {
            dsl.transaction(configuration -> {
                DSLContext create = using(configuration);
                create.insertInto(MOVIE)
                        .columns(MOVIE.ID, MOVIE.TITLE, MOVIE.RELEASE_DATE, MOVIE.GROSS)
                        .values(11, "Test", Date.valueOf(LocalDate.of(2015, 10, 6)), 12345677)
                        .execute();
                System.out.println(create.selectFrom(MOVIE).fetch());
                throw new RuntimeException("Rolling back transaction");
            });
        }
        catch (RuntimeException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println(dsl.selectFrom(MOVIE).fetch());
        }
    }
}
