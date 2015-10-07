package com.example.jooq.test;

import com.example.jooq.model.tables.records.MovieRecord;
import com.example.jooq.util.Util;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.SelectSelectStep;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;

import static com.example.jooq.model.tables.Movie.MOVIE;

public class ActiveRecordTest {

    @Test
    public void testActiveRecord() throws Exception {
        DSLContext dsl = DSL.using(Util.createDataSource(), SQLDialect.POSTGRES);


        //selecting
        MovieRecord jurassicWorld = dsl.selectFrom(MOVIE)
                .where(MOVIE.ID.eq(1))
                .fetchOne();


        //insert
        MovieRecord movie = dsl.newRecord(MOVIE);
        movie.setId(11);
        movie.setTitle("Furious 6");
        movie.setReleaseDate(Date.valueOf(LocalDate.of(2015, 4, 3)));
        movie.setGross(147163560);
        movie.store();


        //updating
        movie.setTitle("Furious 7");
        movie.store();

        //deleting
        movie.delete();

        System.out.println(
                dsl.selectFrom(MOVIE)
                        .fetch()
        );
    }
}
