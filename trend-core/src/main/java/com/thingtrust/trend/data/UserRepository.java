package com.thingtrust.trend.data;



import com.thingtrust.trend.common.mybatis.data.CrudRepository;
import com.thingtrust.trend.domain.User;
import com.thingtrust.trend.domain.example.UserExample;
import org.springframework.stereotype.Repository;

						/**
 *  数据访问类
 * @author wangli
 * @date 2018-10-09
 */
@Repository
public interface UserRepository
    extends CrudRepository<User, UserExample, Integer> {
}
