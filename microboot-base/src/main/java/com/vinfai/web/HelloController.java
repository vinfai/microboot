package com.vinfai.web;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.vinfai.config.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * hello world
 * @author vinfai
 * @since 2017-11-04
 */
@RestController
public class HelloController {

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return "hello ,"+name;
    }

    @RequestMapping("/show")
    public String showRandom() {
        return new Random().nextInt(25)+",aabbc";
    }

    @Autowired
    private UserConfig userConfig;

    @RequestMapping("/show/user")
    public String showUser() {
        return userConfig.toString();
    }
}
