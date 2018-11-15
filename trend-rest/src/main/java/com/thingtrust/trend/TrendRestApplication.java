package com.thingtrust.trend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.thingtrust.trend.data")
@EnableScheduling
public class TrendRestApplication {

    public static void main(final String[] args) {
        SpringApplication.run(TrendRestApplication.class, args);
    }
}
