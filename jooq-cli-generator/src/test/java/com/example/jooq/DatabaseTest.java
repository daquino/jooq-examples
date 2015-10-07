package com.example.jooq;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static com.example.jooq.model.tables.Actor.ACTOR;
import static com.example.jooq.model.tables.CastMember.CAST_MEMBER;
import static com.example.jooq.model.tables.Movie.MOVIE;

public class DatabaseTest {

    @Test
    public void testDatabase() throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sample", "daquino", "");
        DSLContext context = DSL.using(connection);

        System.out.println(
                context.select(ACTOR.FIRST_NAME, ACTOR.LAST_NAME)
                        .from(ACTOR)
                        .fetch()
        );

        System.out.println("");

        System.out.println(
                context.select(MOVIE.TITLE, MOVIE.RELEASE_DATE, MOVIE.GROSS)
                        .from(MOVIE)
                        .orderBy(MOVIE.TITLE.asc())
                        .fetch()
        );

        System.out.println("");
        System.out.println(
                context.select(MOVIE.TITLE, ACTOR.FIRST_NAME.concat(" ").concat(ACTOR.LAST_NAME).as("actor_name"), CAST_MEMBER.CHARACTER_NAME)
                        .from(MOVIE, ACTOR, CAST_MEMBER)
                        .where(CAST_MEMBER.MOVIE_ID.eq(MOVIE.ID)
                                .and(CAST_MEMBER.ACTOR_ID.eq(ACTOR.ID)))
                        .orderBy(MOVIE.TITLE.asc())
                        .fetch()
        );


    }
}
