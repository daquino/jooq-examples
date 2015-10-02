/**
 * This class is generated by jOOQ
 */
package com.example.jooq.model.tables;


import com.example.jooq.model.Keys;
import com.example.jooq.model.Public;
import com.example.jooq.model.tables.records.MovieRecord;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.4"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Movie extends TableImpl<MovieRecord> {

	private static final long serialVersionUID = -1195713805;

	/**
	 * The reference instance of <code>public.movie</code>
	 */
	public static final Movie MOVIE = new Movie();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<MovieRecord> getRecordType() {
		return MovieRecord.class;
	}

	/**
	 * The column <code>public.movie.id</code>.
	 */
	public final TableField<MovieRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>public.movie.title</code>.
	 */
	public final TableField<MovieRecord, String> TITLE = createField("title", org.jooq.impl.SQLDataType.CLOB, this, "");

	/**
	 * The column <code>public.movie.release_date</code>.
	 */
	public final TableField<MovieRecord, Date> RELEASE_DATE = createField("release_date", org.jooq.impl.SQLDataType.DATE, this, "");

	/**
	 * The column <code>public.movie.gross</code>.
	 */
	public final TableField<MovieRecord, Integer> GROSS = createField("gross", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * Create a <code>public.movie</code> table reference
	 */
	public Movie() {
		this("movie", null);
	}

	/**
	 * Create an aliased <code>public.movie</code> table reference
	 */
	public Movie(String alias) {
		this(alias, MOVIE);
	}

	private Movie(String alias, Table<MovieRecord> aliased) {
		this(alias, aliased, null);
	}

	private Movie(String alias, Table<MovieRecord> aliased, Field<?>[] parameters) {
		super(alias, Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<MovieRecord> getPrimaryKey() {
		return Keys.MOVIE_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<MovieRecord>> getKeys() {
		return Arrays.<UniqueKey<MovieRecord>>asList(Keys.MOVIE_PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Movie as(String alias) {
		return new Movie(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Movie rename(String name) {
		return new Movie(name, null);
	}
}
