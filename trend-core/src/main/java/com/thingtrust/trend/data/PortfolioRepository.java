package com.thingtrust.trend.data;

import com.thingtrust.trend.common.mybatis.data.CrudRepository;
import com.thingtrust.trend.domain.Portfolio;
import com.thingtrust.trend.domain.example.PortfolioExample;
import org.springframework.stereotype.Repository;

									/**
 *  数据访问类
 * @author wangli
 * @date 2018-10-12
 */
@Repository
public interface PortfolioRepository
    extends CrudRepository<Portfolio, PortfolioExample, Integer> {
}
