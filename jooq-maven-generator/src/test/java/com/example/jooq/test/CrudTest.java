package com.example.jooq.test;

import com.example.jooq.LoggingListener;
import com.example.jooq.util.Util;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.SelectOrderByStep;
import org.jooq.conf.RenderNameStyle;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

import static com.example.jooq.model.tables.Actor.ACTOR;

public class CrudTest {

    private DSLContext dsl;

    @Before
    public void setUp() throws Exception {
        dsl = DSL.using(new DefaultConfiguration()
                .set(new Settings().withRenderNameStyle(RenderNameStyle.LOWER))
                .set(Util.createDataSource())
                .set(SQLDialect.POSTGRES)
                .set(new DefaultExecuteListenerProvider(new LoggingListener())));
    }

    @After
    public void tearDown() throws Exception {
        dsl = null;
    }

    @Test
    public void testSelect() throws Exception {
        System.out.println(
                dsl.select(ACTOR.LAST_NAME, ACTOR.FIRST_NAME)
                        .from(ACTOR)
                        .orderBy(ACTOR.LAST_NAME)
                        .fetch()
        );


        dsl.select(ACTOR.LAST_NAME, ACTOR.FIRST_NAME)
                .from(ACTOR)
                .orderBy(ACTOR.LAST_NAME)
                .fetch();


    }

    @Test
    public void testInsert() throws Exception {

        dsl.insertInto(ACTOR)
                .columns(ACTOR.ID, ACTOR.FIRST_NAME, ACTOR.LAST_NAME)
                .values(14, "yneth", "Pltrow")
                .execute();

        printActors();
    }

    private void printActors() {
        System.out.println(
                dsl.select(ACTOR.ID, ACTOR.FIRST_NAME, ACTOR.LAST_NAME)
                        .from(ACTOR)
                        .fetch()
        );
    }

    @Test
    public void testUpdate() throws Exception {

        dsl.update(ACTOR)
                .set(ACTOR.LAST_NAME, "Paltrow")
                .set(ACTOR.FIRST_NAME, "Gwyneth")
                .where(ACTOR.ID.eq(14))
                .execute();

        printActors();
    }

    @Test
    public void testDelete() throws Exception {

        dsl.delete(ACTOR)
                .where(ACTOR.ID.eq(14))
                .execute();

        printActors();
    }

    @Test
    public void testInMemoryResults() throws Exception {
        Result result;
        Connection aConnection;
        try (Connection connection = Util.createConnection()) {
            DSLContext context = DSL.using(connection, SQLDialect.POSTGRES);
            result = context.select(ACTOR.LAST_NAME, ACTOR.FIRST_NAME)
                    .from(ACTOR)
                    .orderBy(ACTOR.LAST_NAME)
                    .fetch();
            aConnection = connection;
        }

        System.out.println("Is connection closed? " + aConnection.isClosed());
        System.out.println(result);

    }
}
