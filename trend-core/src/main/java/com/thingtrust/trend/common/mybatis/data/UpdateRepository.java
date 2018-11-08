package com.thingtrust.trend.common.mybatis.data;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UpdateRepository<T, U> {
    int updateById(@Param("record") T var1);

    int updateByExample(@Param("record") T var1, @Param("example") U var2);

    int batchUpdate(@Param("records") List<T> var1);
}