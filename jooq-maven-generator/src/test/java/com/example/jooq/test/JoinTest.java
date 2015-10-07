package com.example.jooq.test;

import com.example.jooq.LoggingListener;
import com.example.jooq.util.Util;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.RenderNameStyle;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.junit.Before;
import org.junit.Test;

import static com.example.jooq.model.tables.Actor.ACTOR;
import static com.example.jooq.model.tables.CastMember.CAST_MEMBER;
import static com.example.jooq.model.tables.Movie.MOVIE;

public class JoinTest {

    private DSLContext dsl;

    @Before
    public void setUp() throws Exception {
        dsl = DSL.using(new DefaultConfiguration()
                .set(new Settings().withRenderNameStyle(RenderNameStyle.LOWER))
                .set(Util.createDataSource())
                .set(SQLDialect.POSTGRES)
                .set(new DefaultExecuteListenerProvider(new LoggingListener())));
    }

    @Test
    public void testJoin() throws Exception {
        System.out.println(

                dsl.select(MOVIE.TITLE.as("movie_title"), CAST_MEMBER.CHARACTER_NAME,
                        ACTOR.FIRST_NAME.concat(" ").concat(ACTOR.LAST_NAME).as("actor_name"))
                        .from(CAST_MEMBER)
                        .join(MOVIE).on(CAST_MEMBER.MOVIE_ID.eq(MOVIE.ID))
                        .join(ACTOR).on(CAST_MEMBER.ACTOR_ID.eq(ACTOR.ID))
                        .where(ACTOR.FIRST_NAME.eq("Bryce"))
                        .and(ACTOR.LAST_NAME.eq("Howard"))
                        .fetch()
                
        );
    }
}
