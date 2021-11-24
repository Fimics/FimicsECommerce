package com.mic.foo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

//@Controller SpringMVC中使用的比较多，可用于界面跳转
@RestController  //spring boot中返回restful 格式
@ApiIgnore
public class HelloController {

    final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public String hello(){
        logger.debug("debug : hello");
        logger.error("error : hello");
        logger.info("info : hello");
        logger.warn("warn : hello");
        return "hello world";
    }
}
