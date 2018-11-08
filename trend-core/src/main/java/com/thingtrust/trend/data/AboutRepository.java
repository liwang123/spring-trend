package com.thingtrust.trend.data;

import com.thingtrust.trend.common.mybatis.data.CrudRepository;
import com.thingtrust.trend.domain.About;
import com.thingtrust.trend.domain.example.AboutExample;
import org.springframework.stereotype.Repository;

							/**
 *  数据访问类
 * @author wangli
 * @date 2018-10-10
 */
@Repository
public interface AboutRepository
    extends CrudRepository<About, AboutExample, Integer> {
}
