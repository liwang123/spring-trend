package com.thingtrust.trend.data;

import com.thingtrust.trend.common.mybatis.data.CrudRepository;
import com.thingtrust.trend.domain.Contact;
import com.thingtrust.trend.domain.example.ContactExample;
import org.springframework.stereotype.Repository;

										/**
 *  数据访问类
 * @author wangli
 * @date 2018-10-11
 */
@Repository
public interface ContactRepository
    extends CrudRepository<Contact, ContactExample, Integer> {
}
