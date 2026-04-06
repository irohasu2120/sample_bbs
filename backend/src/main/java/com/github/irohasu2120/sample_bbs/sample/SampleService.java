package com.github.irohasu2120.sample_bbs.sample;


import com.github.irohasu2120.sample_bbs.db.domain.SampleDSLSupport;
import com.github.irohasu2120.sample_bbs.db.mapper.SampleMapper;
import lombok.RequiredArgsConstructor;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.stereotype.Service;

import java.util.Map;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

@Service
@RequiredArgsConstructor
public class SampleService {

    private final SampleMapper sampleMapper;

    public String mainRoutine() {
        Map<String, Object> result =  sampleMapper.selectOneMappedRow(generateFindOneCondition(1));
        return ((String)result.get("name"));
    }

    private SelectStatementProvider generateFindOneCondition(Integer id) {
        return select(SampleDSLSupport.sample.allColumns()).from(SampleDSLSupport.sample).where(SampleDSLSupport.id, isEqualTo(id)).build().render(RenderingStrategies.MYBATIS3);
    }
}
