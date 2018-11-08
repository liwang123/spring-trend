package com.thingtrust.trend.common.mybatis.data;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface  InsertRepository<T> {
    Long insert(@Param("record") T var1);

    int batchInsert(@Param("records") List<T> var1);

    int batchInsertOnDuplicateKey(@Param("records") List<T> var1);
}
