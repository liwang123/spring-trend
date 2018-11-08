package com.thingtrust.trend.common.mybatis.data;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeleteRepository<T, U, K> {
    int deleteById(@Param("id") K var1);

    int deleteByExample(@Param("example") U var1);

    int deleteIn(@Param("records") List<T> var1);
}
