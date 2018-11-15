package com.thingtrust.trend.data;

import com.thingtrust.trend.common.mybatis.data.CrudRepository;
import com.thingtrust.trend.domain.Tezos;
import com.thingtrust.trend.domain.example.TezosExample;
import org.springframework.stereotype.Repository;

/**
 * 数据访问类
 *
 * @author wangli
 * @date 2018-11-14
 */
@Repository
public interface TezosRepository
        extends CrudRepository<Tezos, TezosExample, Integer> {


}
