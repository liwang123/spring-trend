package com.thingtrust.trend.rest;

import com.thingtrust.trend.common.model.ResponseResult;
import com.thingtrust.trend.domain.About;
import com.thingtrust.trend.service.AboutService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/about")
@Slf4j
public class AboutController {
    @Autowired
    private AboutService aboutService;

    @PostMapping("/add-about")
    public ResponseResult addAbout(final About about) {
        aboutService.insertAbout(about);
        return ResponseResult.success();
    }

    @PostMapping("/update-about")
    public ResponseResult updateAbout(final About about) {
        aboutService.updateAbout(about);
        return ResponseResult.success();
    }

    @GetMapping("/show-all")
    public ResponseResult showAll() {
        final List<About> aboutList = aboutService.showAll();
        return ResponseResult.success(aboutList);
    }

    @GetMapping("/show-one")
    public ResponseResult showOne(final int status) {
        final List<About> aboutList = aboutService.showOne(status);
        return ResponseResult.success(aboutList);
    }

    @PostMapping("/remove")
    public ResponseResult remove(final int id) {
        aboutService.deleteAbout(id);
        return ResponseResult.success();
    }
}
