package com.example.jooq;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.Test;

import static com.example.jooq.model.tables.Actor.ACTOR;

public class CrudTest {

    @Test
    public void testSelect() throws Exception {
        DSLContext context = DSL.using(Util.createDataSource(), SQLDialect.POSTGRES);
        System.out.println(
                context.select(ACTOR.LAST_NAME, ACTOR.FIRST_NAME)
                        .from(ACTOR)
                        .orderBy(ACTOR.LAST_NAME)
                        .fetch()
        );
    }

    @Test
    public void testInsert() throws Exception {
        DSLContext context = DSL.using(Util.createDataSource(), SQLDialect.POSTGRES);
        context.insertInto(ACTOR)
                .columns(ACTOR.ID, ACTOR.FIRST_NAME, ACTOR.LAST_NAME)
                .values(14, "yneth", "Pltrow")
                .execute();

        printActors(context);
    }

    private void printActors(final DSLContext context) {
        System.out.println(
                context.select(ACTOR.ID, ACTOR.FIRST_NAME, ACTOR.LAST_NAME)
                        .from(ACTOR)
                        .fetch()
        );
    }

    @Test
    public void testUpdate() throws Exception {
        DSLContext context = DSL.using(Util.createDataSource(), SQLDialect.POSTGRES);
        context.update(ACTOR)
                .set(ACTOR.LAST_NAME, "Paltrow")
                .set(ACTOR.FIRST_NAME, "Gwyneth")
                .where(ACTOR.ID.eq(14))
                .execute();

        printActors(context);
    }

    @Test
    public void testDelete() throws Exception {
        DSLContext context = DSL.using(Util.createDataSource(), SQLDialect.POSTGRES);
        context.delete(ACTOR)
                .where(ACTOR.ID.eq(14))
                .execute();

        printActors(context);
    }
}
