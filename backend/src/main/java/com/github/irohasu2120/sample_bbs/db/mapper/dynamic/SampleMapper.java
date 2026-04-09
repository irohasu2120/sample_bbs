package com.github.irohasu2120.sample_bbs.db.mapper.dynamic;

import com.github.irohasu2120.sample_bbs.db.domain.dynamic.Sample;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonSelectMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;

@Mapper
public interface SampleMapper extends CommonSelectMapper, CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Sample>, CommonUpdateMapper {
}
