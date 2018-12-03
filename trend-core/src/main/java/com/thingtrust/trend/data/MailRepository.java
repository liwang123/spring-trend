package com.thingtrust.trend.data;

import com.thingtrust.trend.common.mybatis.data.CrudRepository;
import com.thingtrust.trend.domain.Mail;
import com.thingtrust.trend.domain.example.MailExample;
import org.springframework.stereotype.Repository;

								/**
 *  数据访问类
 * @author wangli
 * @date 2018-12-03
 */
@Repository
public interface MailRepository
    extends CrudRepository<Mail, MailExample, Integer> {
}
