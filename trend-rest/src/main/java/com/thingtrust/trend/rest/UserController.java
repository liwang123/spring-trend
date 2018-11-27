package com.thingtrust.trend.rest;


import com.thingtrust.trend.common.model.ResponseResult;
import com.thingtrust.trend.domain.User;
import com.thingtrust.trend.entity.UserEntity;
import com.thingtrust.trend.service.UserService;
import com.thingtrust.trend.util.ImageUtils.Captcha;
import com.thingtrust.trend.util.ImageUtils.GifCaptcha;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ResponseResult login(final UserEntity userEntity, final String code, final HttpSession session) {
        if (StringUtils.isEmpty(userEntity.getUsername()) || StringUtils.isBlank(userEntity.getUsername())) {
            return ResponseResult.failure(4001, "账号不能为空");
        }
        if (StringUtils.isEmpty(userEntity.getPassword()) || StringUtils.isBlank(userEntity.getPassword())) {
            return ResponseResult.failure(4001, "密码不能为空");
        }
        if (StringUtils.isEmpty(code) || StringUtils.isBlank(code)) {
            return ResponseResult.failure(4001, "验证码不能为空");
        }
        final String vcode = (String) session.getAttribute("icode");
        if (!code.toLowerCase().equals(vcode)) {
            return ResponseResult.failure(4001, "验证码不正确");
        }
        final User login = userService.login(userEntity);
        if (login == null) {
            return ResponseResult.failure(4001, "账号或密码错误");
        }
        return ResponseResult.success(login);
    }

    @PostMapping("/add-user")
    public ResponseResult insertUser(final UserEntity userEntity) {
        userService.insertUser(userEntity);
        return ResponseResult.success();
    }

    @PostMapping("/upodate-user")
    public ResponseResult updateUser(final UserEntity userEntity) {
        userService.updateUser(userEntity);
        return ResponseResult.success();
    }

    @GetMapping("/verification")
    public void getValidate(final HttpServletResponse response, final HttpSession session) {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/gif");
        /**
         * gif格式动画验证码
         * 宽，高，位数。
         */
        try {
            final Captcha captcha = new GifCaptcha(146, 33, 4);
            //输出
            captcha.out(response.getOutputStream());
            //存入Session
            session.setAttribute("icode", captcha.text().toLowerCase());

            final String icode = session.getAttribute("icode").toString();
        } catch (final IOException e) {
        }
    }
}
