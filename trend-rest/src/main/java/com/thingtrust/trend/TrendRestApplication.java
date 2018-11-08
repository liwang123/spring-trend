package com.thingtrust.trend;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.thingtrust.trend.data")
public class TrendRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrendRestApplication.class, args);
    }
}
