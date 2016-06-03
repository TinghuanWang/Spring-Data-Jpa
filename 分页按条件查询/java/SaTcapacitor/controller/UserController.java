package com.tiedate.csmiswh.business.SaTcapacitor.controller;

import com.tiedate.csmiswh.business.SaTcapacitor.data.UserModel;
import com.tiedate.csmiswh.business.SaTcapacitor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wth on 2016/6/1.
 */
@Controller
@RequestMapping("/usermodel")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "getDatas")
    List<UserModel> getDatas(@RequestParam Integer rows,@RequestParam Integer page){
        System.out.println("--"+rows);
        System.out.println("--"+page);
        return userService.getDatas(rows,page);
    }
}
