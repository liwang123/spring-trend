package com.thingtrust.trend.service;


import com.thingtrust.trend.data.BannerRepository;
import com.thingtrust.trend.domain.Banner;
import com.thingtrust.trend.domain.example.BannerExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService {

    @Autowired
    private BannerRepository bannerRepository;

    public void insertBanner(final Banner banner) {
        bannerRepository.insert(banner);
    }

    public List<Banner> queryAll() {
        return bannerRepository.selectByExample(null);
    }

    public List<Banner> queryOne(final int status) {
        final BannerExample bannerExample = new BannerExample();
        bannerExample.createCriteria()
                .andStatusEqualTo(status);
        return bannerRepository.selectByExample(bannerExample);
    }

    public void updateBanner(final Banner banner) {
        bannerRepository.updateById(banner);
    }
}
