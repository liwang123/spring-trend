package com.thingtrust.trend.rest;

import com.thingtrust.trend.common.model.ResponseResult;
import com.thingtrust.trend.domain.Question;
import com.thingtrust.trend.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/quest")
@Slf4j
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping("/add-quest")
    public ResponseResult addAbout(final Question question) {
        questionService.insertQuest(question);
        return ResponseResult.success();
    }

    @PostMapping("/update-quest")
    public ResponseResult updateAbout(final Question question) {
        questionService.updateQuest(question);
        return ResponseResult.success();
    }


    @GetMapping("/show-one")
    public ResponseResult showOne(final int status) {
        final List<Question> questionList = questionService.showOne(status);
        questionList.stream()
                .forEach(str -> {
                    System.out.println();
                });
        return ResponseResult.success(questionList);
    }

    @PostMapping("/remove")
    public ResponseResult remove(final int id) {
        questionService.deleteQuest(id);
        return ResponseResult.success();
    }
}
