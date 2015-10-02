/**
 * This class is generated by jOOQ
 */
package com.example.jooq.model.tables;


import com.example.jooq.model.Keys;
import com.example.jooq.model.Public;
import com.example.jooq.model.tables.records.CastMemberRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
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
public class CastMember extends TableImpl<CastMemberRecord> {

	private static final long serialVersionUID = 1086538953;

	/**
	 * The reference instance of <code>public.cast_member</code>
	 */
	public static final CastMember CAST_MEMBER = new CastMember();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<CastMemberRecord> getRecordType() {
		return CastMemberRecord.class;
	}

	/**
	 * The column <code>public.cast_member.movie_id</code>.
	 */
	public final TableField<CastMemberRecord, Integer> MOVIE_ID = createField("movie_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>public.cast_member.actor_id</code>.
	 */
	public final TableField<CastMemberRecord, Integer> ACTOR_ID = createField("actor_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>public.cast_member.character_name</code>.
	 */
	public final TableField<CastMemberRecord, String> CHARACTER_NAME = createField("character_name", org.jooq.impl.SQLDataType.CLOB, this, "");

	/**
	 * Create a <code>public.cast_member</code> table reference
	 */
	public CastMember() {
		this("cast_member", null);
	}

	/**
	 * Create an aliased <code>public.cast_member</code> table reference
	 */
	public CastMember(String alias) {
		this(alias, CAST_MEMBER);
	}

	private CastMember(String alias, Table<CastMemberRecord> aliased) {
		this(alias, aliased, null);
	}

	private CastMember(String alias, Table<CastMemberRecord> aliased, Field<?>[] parameters) {
		super(alias, Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<CastMemberRecord> getPrimaryKey() {
		return Keys.CAST_MEMBER_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<CastMemberRecord>> getKeys() {
		return Arrays.<UniqueKey<CastMemberRecord>>asList(Keys.CAST_MEMBER_PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ForeignKey<CastMemberRecord, ?>> getReferences() {
		return Arrays.<ForeignKey<CastMemberRecord, ?>>asList(Keys.CAST_MEMBER__CAST_MEMBER_MOVIE_ID_FKEY, Keys.CAST_MEMBER__CAST_MEMBER_ACTOR_ID_FKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CastMember as(String alias) {
		return new CastMember(alias, this);
	}

	/**
	 * Rename this table
	 */
	public CastMember rename(String name) {
		return new CastMember(name, null);
	}
}
