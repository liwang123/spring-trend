package com.thingtrust.trend.data;

import com.thingtrust.trend.common.mybatis.data.CrudRepository;
import com.thingtrust.trend.domain.Question;
import com.thingtrust.trend.domain.example.QuestionExample;
import org.springframework.stereotype.Repository;

									/**
 *  数据访问类
 * @author wangli
 * @date 2018-10-12
 */
@Repository
public interface QuestionRepository
    extends CrudRepository<Question, QuestionExample, Integer> {
}
