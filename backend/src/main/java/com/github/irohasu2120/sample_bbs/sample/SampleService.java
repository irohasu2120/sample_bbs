package com.github.irohasu2120.sample_bbs.sample;


import com.github.irohasu2120.sample_bbs.db.domain.Sample;
import com.github.irohasu2120.sample_bbs.db.domain.SampleDSLSupport;
import com.github.irohasu2120.sample_bbs.db.mapper.SampleMapper;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

/**
 * サンプル Service
 */
@Service
@RequiredArgsConstructor
public class SampleService {
    private final SampleMapper sampleMapper;

    /**
     * Service
     * @return 実行結果
     */
    public String mainRoutine() {
        SelectStatementProvider stmt = getSelectStatementProvider();
        List<Sample> result = sampleMapper.selectMany(stmt);
        return result.getFirst().getName();
    }

    /**
     * 検索SQL Statementの生成
     * @return 検索SQLStatement
     */
    private static @NonNull SelectStatementProvider getSelectStatementProvider() {
        return select(SampleDSLSupport.sample.allColumns())
                .from(SampleDSLSupport.sample)
                .where(SampleDSLSupport.sample.id, isEqualTo(1))
                .build().render(RenderingStrategies.MYBATIS3);
    }
}
