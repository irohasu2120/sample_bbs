package com.github.irohasu2120.sample_bbs.db.mapper;

import com.github.irohasu2120.sample_bbs.db.domain.Sample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import java.util.List;

@Mapper
public interface SampleMapper {
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
//    @ResultMap("Sample")
    List<Sample> selectMany(SelectStatementProvider provider);
}
