package com.thingtrust.trend.rest;

import com.thingtrust.trend.common.model.ResponseResult;
import com.thingtrust.trend.domain.Banner;
import com.thingtrust.trend.service.BannerService;
import com.thingtrust.trend.util.CosUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/v1/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @PostMapping("/add-banner")
    public ResponseResult addBanner(final Banner banner) {
        bannerService.insertBanner(banner);
        return ResponseResult.success();
    }

    @PostMapping("/upload-image")
    public ResponseResult uploadImage(final MultipartFile file) throws Exception {
        final CosUtil cosUtil = new CosUtil();
        final String url = cosUtil.uploadFile2Cos(file);
        return ResponseResult.success(url);
    }

    @GetMapping("/show-all")
    public ResponseResult showAll() {
        final List<Banner> bannerList = bannerService.queryAll();
        return ResponseResult.success(bannerList);
    }

    @GetMapping("/show-one")
    public ResponseResult showOne(final int status) {
        final List<Banner> bannerList = bannerService.queryOne(status);
        return ResponseResult.success(bannerList);
    }

    @PostMapping("/update-banner")
    public ResponseResult updateBanner(final Banner banner) {
        bannerService.updateBanner(banner);
        return ResponseResult.success();
    }
}
