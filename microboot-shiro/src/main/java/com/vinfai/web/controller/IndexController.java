package com.vinfai.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * index page
 * @author fangwenhui
 * @date 2017-12-15 17:07
 **/
@Controller
public class IndexController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = {"/","/index"})
    public String index() {
        logger.debug("show index");
        return "index";
    }


    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {

        return "hello";
    }

    @RequestMapping(value ={"/admin/","/admin/index"})
    public String index2(){
        logger.info("admin index page.");
        return "admin/index";
    }

    @RequestMapping(value = {"/admin/welcome"})
    public String welcome(){

        return "admin/welcome";
    }

}
