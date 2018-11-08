package com.thingtrust.trend.common.mybatis.data;



public interface CrudRepository<T, U, K> extends InsertRepository<T>, DeleteRepository<T, U, K>, UpdateRepository<T, U>, SelectRepository<T, U, K> {
}