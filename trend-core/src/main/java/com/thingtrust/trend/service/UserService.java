package com.thingtrust.trend.service;


import com.thingtrust.trend.data.UserRepository;
import com.thingtrust.trend.domain.User;
import com.thingtrust.trend.domain.example.UserExample;
import com.thingtrust.trend.entity.UserEntity;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User login(final UserEntity userEntity) {
        final String password = DigestUtils.md5Hex(userEntity.getPassword());
        final UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andUsernameEqualTo(userEntity.getUsername())
                .andPasswordEqualTo(password);
        final User user = userRepository.selectOneByExample(userExample);
        return user;
    }

    public void insertUser(final UserEntity userEntity) {
        final User user = User.builder().build();
        BeanUtils.copyProperties(userEntity, user);
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        userRepository.insert(user);
    }

    public void updateUser(final UserEntity userEntity) {
        final UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andUsernameEqualTo(userEntity.getUsername());
        final User user = userRepository.selectOneByExample(userExample);
        user.setPassword(DigestUtils.md5Hex(userEntity.getPassword()));
        userRepository.updateById(user);

    }

}
