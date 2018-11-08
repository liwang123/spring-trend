package com.thingtrust.trend.data;

import com.thingtrust.trend.common.mybatis.data.CrudRepository;
import com.thingtrust.trend.domain.Banner;
import com.thingtrust.trend.domain.example.BannerExample;
import org.springframework.stereotype.Repository;

														/**
 *  数据访问类
 * @author wangli
 * @date 2018-10-10
 */
@Repository
public interface BannerRepository
    extends CrudRepository<Banner, BannerExample, Integer> {
}
