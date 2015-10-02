/**
 * This class is generated by jOOQ
 */
package com.example.jooq.model.tables.records;


import com.example.jooq.model.tables.Movie;

import java.sql.Date;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


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
public class MovieRecord extends UpdatableRecordImpl<MovieRecord> implements Record4<Integer, String, Date, Integer> {

	private static final long serialVersionUID = 456734877;

	/**
	 * Setter for <code>public.movie.id</code>.
	 */
	public void setId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>public.movie.id</code>.
	 */
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>public.movie.title</code>.
	 */
	public void setTitle(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>public.movie.title</code>.
	 */
	public String getTitle() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>public.movie.release_date</code>.
	 */
	public void setReleaseDate(Date value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>public.movie.release_date</code>.
	 */
	public Date getReleaseDate() {
		return (Date) getValue(2);
	}

	/**
	 * Setter for <code>public.movie.gross</code>.
	 */
	public void setGross(Integer value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>public.movie.gross</code>.
	 */
	public Integer getGross() {
		return (Integer) getValue(3);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Record1<Integer> key() {
		return (Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record4 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row4<Integer, String, Date, Integer> fieldsRow() {
		return (Row4) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row4<Integer, String, Date, Integer> valuesRow() {
		return (Row4) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return Movie.MOVIE.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return Movie.MOVIE.TITLE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Date> field3() {
		return Movie.MOVIE.RELEASE_DATE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field4() {
		return Movie.MOVIE.GROSS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value2() {
		return getTitle();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Date value3() {
		return getReleaseDate();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value4() {
		return getGross();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MovieRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MovieRecord value2(String value) {
		setTitle(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MovieRecord value3(Date value) {
		setReleaseDate(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MovieRecord value4(Integer value) {
		setGross(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MovieRecord values(Integer value1, String value2, Date value3, Integer value4) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached MovieRecord
	 */
	public MovieRecord() {
		super(Movie.MOVIE);
	}

	/**
	 * Create a detached, initialised MovieRecord
	 */
	public MovieRecord(Integer id, String title, Date releaseDate, Integer gross) {
		super(Movie.MOVIE);

		setValue(0, id);
		setValue(1, title);
		setValue(2, releaseDate);
		setValue(3, gross);
	}
}
