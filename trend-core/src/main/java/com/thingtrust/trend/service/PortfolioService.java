package com.thingtrust.trend.service;

import com.thingtrust.trend.data.PortfolioRepository;
import com.thingtrust.trend.domain.Portfolio;
import com.thingtrust.trend.domain.example.PortfolioExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {
    @Autowired
    private PortfolioRepository portfolioRepository;

    public void insertPortfolio(final Portfolio portfolio) {
        portfolioRepository.insert(portfolio);
    }

    public void upodatePortfolio(final Portfolio portfolio) {
        portfolioRepository.updateById(portfolio);

    }

    public List<Portfolio> showAll() {
        final PortfolioExample example = new PortfolioExample();
        example.setOrderByClause("sort");
        return portfolioRepository.selectByExample(example);
    }



    public void deletePort(final int id) {
        portfolioRepository.deleteById(id);
    }
}
