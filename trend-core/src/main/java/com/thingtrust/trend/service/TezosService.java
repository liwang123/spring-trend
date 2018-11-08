package com.thingtrust.trend.service;

import com.thingtrust.trend.data.AboutRepository;
import com.thingtrust.trend.domain.About;
import com.thingtrust.trend.domain.example.AboutExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TezosService {
    @Autowired
    private AboutRepository aboutRepository;

    public void insertAbout(final About about) {
        aboutRepository.insert(about);
    }

    public void updateAbout(final About about) {
        aboutRepository.updateById(about);

    }

    public List<About> showAll() {
        return aboutRepository.selectByExample(null);
    }

    public List<About> showOne(final int status) {
        final AboutExample aboutExample = new AboutExample();
        aboutExample.createCriteria()
                .andStatusEqualTo(status);
        return aboutRepository.selectByExample(aboutExample);
    }

    public void deleteAbout(final int id) {
        aboutRepository.deleteById(id);
    }
}
