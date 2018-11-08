package com.thingtrust.trend.rest;

import com.thingtrust.trend.common.model.ResponseResult;
import com.thingtrust.trend.domain.Portfolio;
import com.thingtrust.trend.service.PortfolioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/portfolio")
@Slf4j
public class PortfolioController {
    @Autowired
    private PortfolioService portfolioService;

    @PostMapping("/add-portfolio")
    public ResponseResult addPortfolio(final Portfolio portfolio) {
        portfolioService.insertPortfolio(portfolio);
        return ResponseResult.success();
    }

    @PostMapping("/update-portfolio")
    public ResponseResult updatePortfolio(final Portfolio portfolio) {
        portfolioService.upodatePortfolio(portfolio);
        return ResponseResult.success();
    }


    @GetMapping("/show-all")
    public ResponseResult showOne() {
        final List<Portfolio> portfolioList = portfolioService.showAll();
        return ResponseResult.success(portfolioList);
    }

    @PostMapping("/remove")
    public ResponseResult remove(final int id) {
        portfolioService.deletePort(id);
        return ResponseResult.success();
    }
}
