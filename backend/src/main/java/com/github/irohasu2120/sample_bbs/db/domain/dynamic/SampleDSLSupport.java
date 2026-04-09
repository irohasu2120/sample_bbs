package com.github.irohasu2120.sample_bbs.db.domain.dynamic;

import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

import java.sql.JDBCType;

public final class SampleDSLSupport {
    public static final Sample sample = new Sample();

    public static final SqlColumn <Integer> id = sample.id;
    public static final SqlColumn <String> name = sample.name;

    public static final class Sample extends AliasableSqlTable<Sample> {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);
        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);


        public Sample() {
            super("sample", Sample::new);
        }
    }
}
