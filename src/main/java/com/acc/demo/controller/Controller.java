package com.acc.demo.controller;

import com.acc.demo.dao.UserInfoDAO;
import com.acc.demo.entity.UserInfo;
import com.acc.demo.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    UserInfoService userInfoService;

    Logger logger = LoggerFactory.getLogger(Controller.class);
    @GetMapping("/admin")
    public String index(){
        logger.info("Successfull");
        return "welcome to Admin page!!!";
    }

    @GetMapping("/user")
    public String page(){
        logger.info("Error Happened!!!!");
        return "welcome to Login page!!!";
    }


}
