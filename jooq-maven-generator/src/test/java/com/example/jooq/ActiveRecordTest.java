package com.example.jooq;

import com.example.jooq.model.tables.records.MovieRecord;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;

import static com.example.jooq.model.tables.Movie.MOVIE;

public class ActiveRecordTest {

    @Test
    public void testActiveRecord() throws Exception {
        DSLContext dsl = DSL.using(Util.createDataSource(), SQLDialect.POSTGRES);
        MovieRecord movie;


        selectMovie(dsl);
        movie = insertMovie(dsl);
        updateMovie(dsl, movie);
        deleteMovie(dsl, movie);
    }

    private void selectMovie(final DSLContext dsl) {
        MovieRecord movie = dsl.selectFrom(MOVIE).where(MOVIE.ID.eq(1)).fetchOne();
        System.out.println(movie);
    }

    private MovieRecord insertMovie(final DSLContext dsl) {
        MovieRecord movie;
        movie = dsl.newRecord(MOVIE);
        movie.setId(11);
        movie.setTitle("Furious 6");
        movie.setReleaseDate(Date.valueOf(LocalDate.of(2015, 4, 3)));
        movie.setGross(147163560);
        movie.store();

        System.out.println(
                dsl.selectFrom(MOVIE)
                        .fetch()
        );
        return movie;
    }

    private void updateMovie(final DSLContext dsl, final MovieRecord movie) {
        movie.setTitle("Furious 7");
        movie.store();

        System.out.println(
                dsl.selectFrom(MOVIE)
                        .fetch()
        );
    }

    private void deleteMovie(final DSLContext dsl, final MovieRecord movie) {
        movie.delete();
        System.out.println(
                dsl.selectFrom(MOVIE)
                        .fetch()
        );
    }
}
