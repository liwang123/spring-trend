package com.thingtrust.trend.common.mybatis.data;


import com.thingtrust.trend.common.mybatis.pager.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SelectRepository<T, U, K> {
    T selectById(@Param("id") K var1);

    List<T> selectByExample(@Param("example") U var1);

    T selectOneByExample(@Param("example") U var1);

    List<T> selectIn(@Param("records") List<T> var1);

    int countByPager(@Param("pager") PageInfo var1, @Param("example") U var2);

    List<T> selectByPager(@Param("pager") PageInfo var1, @Param("example") U var2);

    int countByExample(@Param("example") U var1);
}
