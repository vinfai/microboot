package com.vinfai.web.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * login
 *
 * @author vinfai
 * @date 2017-12-13 20:49
 **/
@Controller
@RequestMapping("/admin")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin() {
        logger.info("to login");
        return "admin/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String userName, @RequestParam("password") String password, ModelMap model) {

        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            model.put("message", "用户名或密码不能为空！");
            return "admin/login";
        }
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        try {
            SecurityUtils.getSubject().login(token);
            return "redirect:/admin/index";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            token.clear();
            model.put("message", "用户或密码不正确");
        }
        return "admin/login";
    }

}
