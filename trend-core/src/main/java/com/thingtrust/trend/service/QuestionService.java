package com.thingtrust.trend.service;

import com.thingtrust.trend.data.QuestionRepository;
import com.thingtrust.trend.domain.Question;
import com.thingtrust.trend.domain.example.QuestionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public void insertQuest(final Question question) {
        questionRepository.insert(question);
    }

    public void updateQuest(final Question question) {
        questionRepository.updateById(question);

    }


    public List<Question> showOne(final int status) {
        final QuestionExample questionExample = new QuestionExample();
        questionExample.createCriteria()
                .andStatusEqualTo(status);
        questionExample.setOrderByClause("sort");
        return questionRepository.selectByExample(questionExample);
    }

    public void deleteQuest(final int id) {
        questionRepository.deleteById(id);
    }
}
